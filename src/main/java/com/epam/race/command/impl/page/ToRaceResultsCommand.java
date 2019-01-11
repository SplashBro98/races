package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;
import com.epam.race.entity.common.RaceResult;
import com.epam.race.service.RaceResultService;
import com.epam.race.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToRaceResultsCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToRaceResultsCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        try {
            RaceResultService service = new RaceResultService();
            List<RaceResult> raceResultList = service.findAllResults();
            req.setAttribute(StringAttributes.RACE_RESULTS,raceResultList);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_RACE_RESULTS_PAGE);
        }catch (ServiceException e){
            logger.error("Service Exception in ToRaceResultsCommand",e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }

        return page;
    }
}
