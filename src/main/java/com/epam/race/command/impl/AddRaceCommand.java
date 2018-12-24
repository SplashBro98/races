package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Race;
import com.epam.race.exception.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        Race race = new Race();
        race.setName(req.getParameter(StringAttributes.NAME));
        race.setPlace(req.getParameter(StringAttributes.PLACE));
        race.setDate(LocalDate.parse(req.getParameter(StringAttributes.DATE)));
        race.setTime(LocalTime.parse(req.getParameter(StringAttributes.TIME)));

        String page;
        try{

            RaceService raceService = new RaceService();
            raceService.addRace(race);


            RaceService service = new RaceService(1, 5);
            service.findAllRaces();
            req.getSession().setAttribute("currentPage", service.getCurrentPage());
            req.getSession().setAttribute("numberOfPages", service.getNumberOfPages());

            req.getSession().setAttribute(StringAttributes.RACES, service.findCurrentRaces());
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;

    }
}
