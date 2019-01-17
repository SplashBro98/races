package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SelectRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(SelectRaceCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String raceName = req.getParameter(StringAttribute.NAME);
        try {
            RaceService service = new RaceService();
            Race race = service.findRaceWithBetsAndHorses(raceName);

            req.setAttribute(StringAttribute.RACE, race);
            req.getSession().setAttribute(StringAttribute.BETS, race.getBets());
            req.setAttribute(StringAttribute.HORSES, race.getHorses());

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_RACE_PAGE));
        } catch (ServiceException e) {
            logger.error("Service Exception in SelectRaceCommand", e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
