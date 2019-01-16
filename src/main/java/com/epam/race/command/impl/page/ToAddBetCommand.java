package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.common.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class ToAddBetCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToAddBetCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        try{

            RaceService raceService = new RaceService();
            List<Race> races = raceService.findAllUpcomingRaces();
            List<String> raceNames = new ArrayList<>();
            Map<String, Integer> raceNameIdMap = new TreeMap<>();
            races.forEach(new Consumer<Race>() {
                @Override
                public void accept(Race race) {
                    raceNames.add(race.getName());
                    raceNameIdMap.put(race.getName(), race.getRaceId());
                }
            });
            req.getSession().setAttribute(StringAttribute.RACE_NAMES, raceNames);
            req.getSession().setAttribute(StringAttribute.RACE_NAME_ID_MAP, raceNameIdMap);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToAddBetCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
