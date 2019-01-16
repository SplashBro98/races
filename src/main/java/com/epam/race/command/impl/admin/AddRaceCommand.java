package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
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
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        boolean flag = true;

        Race race = new Race();
        race.setName(req.getParameter(StringAttribute.NAME));
        race.setPlace(req.getParameter(StringAttribute.PLACE));
        String date = req.getParameter(StringAttribute.DATE);
        String time = req.getParameter(StringAttribute.TIME);

        try {
            RaceValidator raceValidator = new RaceValidator();
            boolean isCorrectName = raceValidator.checkName(race.getName());
            if (isCorrectName) {
                req.setAttribute(StringAttribute.NAME, race.getName());
            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_NAME, StringAttribute.TRUE);
            }


            boolean isPresentName = raceValidator.checkNameIsPresent(race.getName());
            if (isPresentName) {
                flag = false;
                req.setAttribute(StringAttribute.PRESENT_NAME, StringAttribute.TRUE);
            }


            boolean isCorrectPlace = raceValidator.checkPlace(race.getPlace());
            if (isCorrectPlace) {
                req.setAttribute(StringAttribute.PLACE, race.getPlace());
            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_PLACE, StringAttribute.TRUE);
            }

            boolean isCorrectTime = raceValidator.checkTime(time);
            if (isCorrectTime) {
                race.setTime(LocalTime.parse(time));
                req.setAttribute(StringAttribute.TIME, time);
            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_TIME, StringAttribute.TRUE);
            }

            boolean isCorrectDate = raceValidator.checkDate(date);
            if (isCorrectDate) {
                race.setDate(LocalDate.parse(date));
                req.setAttribute(StringAttribute.DATE, date);
            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_DATE, StringAttribute.TRUE);
            }


            if (flag) {
                RaceService raceService = new RaceService();
                HorseService horseService = new HorseService();

                String firstHorseName = req.getParameter(StringAttribute.HORSE_1);
                String secondHorseName = req.getParameter(StringAttribute.HORSE_2);
                String thirdHorseName = req.getParameter(StringAttribute.HORSE_3);
                String fourthHorseName = req.getParameter(StringAttribute.HORSE_4);

                List<Integer> idList = new ArrayList<>();
                idList.add(horseService.findHorseId(firstHorseName));
                idList.add(horseService.findHorseId(secondHorseName));
                idList.add(horseService.findHorseId(thirdHorseName));
                idList.add(horseService.findHorseId(fourthHorseName));

                if (raceValidator.isDifferentHorses(idList)) {
                    raceService.addRace(race);
                    int raceId = raceService.findRaceId(race.getName());
                    for (int id : idList) {
                        horseService.addHorseToHorseList(raceId, id);
                    }
                } else {
                    req.setAttribute(StringAttribute.NOT_DIFFERENT_HORSES, StringAttribute.TRUE);
                    router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE));
                    return router;
                }

                raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                raceService.findAllUpcomingRaces();
                List<Object> attributes = raceService.mainAttributes();
                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.getSession().setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());

                router.setRedirect();
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
            } else {
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE));
            }
        } catch (ServiceException e) {
            logger.error("Service Exception in AddRaceCommand", e);
            req.setAttribute(StringAttribute.E, e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }

        return router;
    }
}
