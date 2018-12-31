package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.service.ServiceException;
import com.epam.race.service.HorseService;
import com.epam.race.util.constant.StringAttributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectRaceHorsesCommand implements Command {
    private static Logger logger = LogManager.getLogger(SelectRaceHorsesCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String raceName = req.getParameter(StringAttributes.NAME);
        try{
            Map<String, Integer> raceNameIdMap = (Map) req.getSession().getAttribute("raceNameIdMap");
            List<Horse> horses = new HorseService().findHorsesByRace(raceNameIdMap.get(raceName));

            List<String> horseNames = new ArrayList<>();
            horses.forEach(h -> horseNames.add(h.getName()));

            req.getSession().setAttribute("horseNames",horseNames);
            req.getSession().setAttribute("raceName", raceName);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE);

        }catch (ServiceException e){
            logger.error("service problem",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
