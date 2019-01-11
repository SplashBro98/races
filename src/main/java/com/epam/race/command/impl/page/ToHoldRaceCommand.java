package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;
import com.epam.race.entity.common.Race;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ToHoldRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToHoldRaceCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        try{
            List<Race> races = new RaceService().findAllUpcomingRaces();
            List<String> raceNames = new ArrayList<>();
            races.forEach(r -> raceNames.add(r.getName()));
            req.setAttribute("raceNames", raceNames);
            req.setAttribute(StringAttributes.RACES, races);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_HOLD_RACE_PAGE);
        }catch (ServiceException e){
            logger.error("Service Exception in ToHoldRaceCommand",e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
