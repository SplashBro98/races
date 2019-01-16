package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.common.Race;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ToHoldRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToHoldRaceCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        try{
            List<Race> races = new RaceService().findAllUpcomingRaces();
            List<String> raceNames = new ArrayList<>();
            races.forEach(r -> raceNames.add(r.getName()));
            req.setAttribute(StringAttribute.RACE_NAMES, raceNames);
            req.setAttribute(StringAttribute.RACES, races);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_HOLD_RACE_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToHoldRaceCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
