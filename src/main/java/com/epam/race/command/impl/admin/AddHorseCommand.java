package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.service.HorseService;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.validation.HorseValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddHorseCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddHorseCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        boolean flag = true;

        String horseName = req.getParameter(StringAttribute.NAME);
        String horseAge = req.getParameter(StringAttribute.AGE);
        HorseValidator horseValidator = new HorseValidator();

        boolean isCorrectName = horseValidator.isCorrectName(horseName);
        if(isCorrectName){
            req.setAttribute(StringAttribute.NAME,horseName);
        }else {
            flag = false;
            req.setAttribute(StringAttribute.INCORRECT_NAME, StringAttribute.TRUE);
        }

        boolean isCorrectAge = horseValidator.isCorrectAge(horseAge);
        if(isCorrectAge){
            req.setAttribute(StringAttribute.AGE,horseAge);
        }else {
            flag = false;
            req.setAttribute(StringAttribute.INCORRECT_AGE, StringAttribute.TRUE);
        }

        if(flag) {
            try {
                Horse horse = new Horse();
                horse.setName(horseName);
                horse.setAge(Integer.parseInt(horseAge));
                HorseService horseService = new HorseService();
                horseService.addHorse(horse);

                RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                List<Object> attributes = raceService.mainAttributes();
                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.getSession().setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());

                router.setRedirect();
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
            } catch (ServiceException e) {
                logger.error("Service Exception in AddHorseCommand",e);
                req.setAttribute(StringAttribute.E,e);
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
            }
        }else {
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_HORSE_PAGE));
        }
        return router;
    }
}
