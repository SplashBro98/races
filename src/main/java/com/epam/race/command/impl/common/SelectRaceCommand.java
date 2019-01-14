package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SelectRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(SelectRaceCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String raceName = req.getParameter(StringAttributes.NAME);
        try {
            RaceService service = new RaceService();
            Race race = service.findRaceWithBetsAndHorses(raceName);

            req.setAttribute(StringAttributes.RACE, race);
            req.setAttribute(StringAttributes.BETS, race.getBets());
            req.setAttribute(StringAttributes.HORSES, race.getHorses());

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_RACE_PAGE);
        } catch (ServiceException e) {
            logger.error("Service Exception in SelectRaceCommand", e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
