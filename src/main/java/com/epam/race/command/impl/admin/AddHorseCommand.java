package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.service.HorseService;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.command.StringAttributes;
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
    public String execute(HttpServletRequest req) {
        String page;
        boolean flag = true;

        String horseName = req.getParameter(StringAttributes.NAME);
        String horseAge = req.getParameter(StringAttributes.AGE);
        HorseValidator horseValidator = new HorseValidator();

        boolean isCorrectName = horseValidator.isCorrectName(horseName);
        if(isCorrectName){
            req.setAttribute(StringAttributes.NAME,horseName);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.TRUE);
        }

        boolean isCorrectAge = horseValidator.isCorrectAge(horseAge);
        if(isCorrectAge){
            req.setAttribute(StringAttributes.AGE,horseAge);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_AGE, StringAttributes.TRUE);
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
                req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());

                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            } catch (ServiceException e) {
                logger.error("Service Exception in AddHorseCommand",e);
                req.setAttribute(StringAttributes.E,e);
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
            }
        }else {
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_HORSE_PAGE);
        }
        return page;
    }
}
