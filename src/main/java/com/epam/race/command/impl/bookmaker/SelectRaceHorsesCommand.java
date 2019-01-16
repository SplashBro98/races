package com.epam.race.command.impl.bookmaker;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.service.ServiceException;
import com.epam.race.service.HorseService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectRaceHorsesCommand implements Command {
    private static Logger logger = LogManager.getLogger(SelectRaceHorsesCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String raceName = req.getParameter(StringAttribute.NAME);
        try{
            Map<String, Integer> raceNameIdMap = (Map) req.getSession().
                    getAttribute(StringAttribute.RACE_NAME_ID_MAP);
            List<Horse> horses = new HorseService().findHorsesByRace(raceNameIdMap.get(raceName));

            List<String> horseNames = new ArrayList<>();
            horses.forEach(h -> horseNames.add(h.getName()));

            req.setAttribute(StringAttribute.HORSE_NAMES,horseNames);
            req.setAttribute(StringAttribute.RACE_NAME, raceName);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in SelectRaceHorsesCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
