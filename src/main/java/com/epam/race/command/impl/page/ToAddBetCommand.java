package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
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
    public String execute(HttpServletRequest req) {
        String page;

        try{

            List<Race> races = new RaceService().findAllRaces();
            List<String> raceNames = new ArrayList<>();
            Map<String, Integer> raceNameIdMap = new TreeMap<>();
            races.forEach(new Consumer<Race>() {
                @Override
                public void accept(Race race) {
                    raceNames.add(race.getName());
                    raceNameIdMap.put(race.getName(), race.getRaceId());
                }
            });
            req.getSession().setAttribute("raceNames", raceNames);
            req.getSession().setAttribute("raceNameIdMap", raceNameIdMap);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE);
        }catch (ServiceException e){
            logger.error("Problem with service or lower",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
