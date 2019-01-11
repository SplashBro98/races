package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.StringConstant;
import com.epam.race.util.validation.RaceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddRaceCommand.class);

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
                RaceService raceService = new RaceService();
                HorseService horseService = new HorseService();

                String firstHorseName = req.getParameter(StringAttributes.HORSE_1);
                String secondHorseName = req.getParameter(StringAttributes.HORSE_2);
                String thirdHorseName = req.getParameter(StringAttributes.HORSE_3);
                String fourthHorseName = req.getParameter(StringAttributes.HORSE_4);



                List<Integer> idList = new ArrayList<>();
                idList.add(horseService.findHorseId(firstHorseName));
                idList.add(horseService.findHorseId(secondHorseName));
                idList.add(horseService.findHorseId(thirdHorseName));
                idList.add(horseService.findHorseId(fourthHorseName));

                if(raceValidator.isDifferentHorses(idList)){
                    raceService.addRace(race);
                    int raceId = raceService.findRaceId(race.getName());
                    for(int id : idList){
                        horseService.addHorseToHorseList(raceId,id);
                    }
                }else {
                    req.setAttribute(StringAttributes.NOT_DIFFERENT_HORSES,StringAttributes.TRUE);
                    return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE);
                }


                RaceService service = new RaceService(1, 8);
                service.findAllUpcomingRaces();
                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, service.getCurrentPage());
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, service.getNumberOfPages());

                req.getSession().setAttribute(StringAttributes.RACES, service.findCurrentRaces());
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            } catch (ServiceException e) {
                logger.error("Service Exception in AddRaceCommand",e);
                req.setAttribute(StringAttributes.E,e);
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
            }
        }else {
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE);
        }
        return page;
    }
}
