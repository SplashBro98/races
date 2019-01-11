package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.validation.HorseValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddHorseCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddHorseCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String horseName = req.getParameter(StringAttributes.NAME);
        String horseAge = req.getParameter(StringAttributes.AGE);

        HorseValidator horseValidator = new HorseValidator();
        boolean flag = true;

        boolean isCorrectName = horseValidator.isCorrectName(horseName);
        if(isCorrectName){
            req.setAttribute(StringAttributes.NAME,horseName);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.ATTRIBUTE_INCORRECT_NAME);
        }

        boolean isCorrectAge = horseValidator.isCorrectAge(horseAge);
        if(isCorrectAge){
            req.setAttribute(StringAttributes.AGE,horseAge);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_AGE, StringAttributes.ATTRIBUTE_INCORRECT_AGE);
        }

        if(flag) {
            try {

                Horse horse = new Horse();
                horse.setName(horseName);
                horse.setAge(Integer.parseInt(horseAge));

                HorseService horseService = new HorseService();
                horseService.addHorse(horse);


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
