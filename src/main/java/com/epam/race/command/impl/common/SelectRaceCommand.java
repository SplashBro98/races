package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;

import javax.servlet.http.HttpServletRequest;

public class SelectRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        String raceName = req.getParameter(StringAttributes.NAME);
        try {
            RaceService service = new RaceService();
            Race race = service.findRaceWithBetsAndHorses(raceName);

            req.getSession().setAttribute(StringAttributes.RACE, race);
            req.getSession().setAttribute(StringAttributes.BETS, race.getBets());
            req.getSession().setAttribute(StringAttributes.HORSES, race.getHorses());


            page = PageManager.INSTANCE.getProperty(PageManager.PATH_RACE_PAGE);
        } catch (ServiceException e) {
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
