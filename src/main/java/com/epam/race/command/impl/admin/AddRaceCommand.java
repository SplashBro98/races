package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.validation.RaceValidator;
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
        boolean flag = true;

        Race race = new Race();
        race.setName(req.getParameter(StringAttributes.NAME));
        race.setPlace(req.getParameter(StringAttributes.PLACE));
        String date = req.getParameter(StringAttributes.DATE);
        String time = req.getParameter(StringAttributes.TIME);

        RaceValidator raceValidator = new RaceValidator();
        boolean isCorrectName = raceValidator.checkName(race.getName());
        if(isCorrectName){
            req.setAttribute(StringAttributes.NAME,race.getName());
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.TRUE);
        }

        boolean isCorrectPlace = raceValidator.checkPlace(race.getPlace());
        if(isCorrectPlace){
            req.setAttribute(StringAttributes.PLACE,race.getPlace());
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_PLACE, StringAttributes.TRUE);
        }

        boolean isCorrectTime = raceValidator.checkTime(time);
        if(isCorrectTime){
            race.setTime(LocalTime.parse(time));
            req.setAttribute(StringAttributes.TIME,time);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_TIME, StringAttributes.TRUE);
        }

        boolean isCorrectDate = raceValidator.checkDate(date);
        if(isCorrectDate){
            race.setDate(LocalDate.parse(date));
            req.setAttribute(StringAttributes.DATE,date);
        }else {
            flag = false;
            req.setAttribute(StringAttributes.INCORRECT_DATE, StringAttributes.TRUE);
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

                raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                raceService.findAllUpcomingRaces();
                List<Object> attributes = raceService.mainAttributes();
                req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());

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
