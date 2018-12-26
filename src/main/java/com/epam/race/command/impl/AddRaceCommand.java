package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.util.constant.StringAttributes;
import com.epam.race.util.constant.StringConstant;
import com.epam.race.util.validation.RaceValidator;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        String page;
        Race race = new Race();
        race.setName(req.getParameter(StringAttributes.NAME));
        race.setPlace(req.getParameter(StringAttributes.PLACE));
        String date = req.getParameter(StringAttributes.DATE);
        String time = req.getParameter(StringAttributes.TIME);

        RaceValidator raceValidator = new RaceValidator();
        boolean flag = true;


        boolean isCorrectName = raceValidator.checkName(race.getName());
        if(isCorrectName){
            req.setAttribute(StringAttributes.NAME,race.getName());
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.ATTRIBUTE_INCORRECT_NAME);
        }

        boolean isCorrectPlace = raceValidator.checkPlace(race.getPlace());
        if(isCorrectPlace){
            req.setAttribute(StringAttributes.PLACE,race.getPlace());
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_PLACE, StringAttributes.ATTRIBUTE_INCORRECT_PLACE);
        }

        boolean isCorrectTime = raceValidator.checkTime(time);
        if(isCorrectTime){
            race.setTime(LocalTime.parse(time));
            req.setAttribute(StringAttributes.TIME,time);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_TIME, StringAttributes.ATTRIBUTE_INCORRECT_TIME);
        }

        boolean isCorrectDate = raceValidator.checkDate(date);
        if(isCorrectDate){
            race.setDate(LocalDate.parse(date));
            req.setAttribute(StringAttributes.DATE,date);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_DATE, StringAttributes.ATTRIBUTE_INCORRECT_DATE);
        }


        if(flag) {
            try {

                String firstHorseName = req.getParameter("horse№1");
                String secondHorseName = req.getParameter("horse№2");
                String thirdHorseName = req.getParameter("horse№3");
                String fourthHorseName = req.getParameter("horse№4");

                RaceService raceService = new RaceService();
                raceService.addRace(race);

                RaceService service = new RaceService(1, 5);
                service.findAllRaces();
                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, service.getCurrentPage());
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, service.getNumberOfPages());

                req.getSession().setAttribute(StringAttributes.RACES, service.findCurrentRaces());
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            } catch (ServiceException e) {
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
            }
        }else {
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE);
        }
        return page;
    }
}
