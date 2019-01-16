package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToMainCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToMainCommand.class);


    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        try {
            RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                    IntegerConstant.COUNT_OF_RACES);
            List<Integer> attributes = raceService.mainAttributes();
            req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
            req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
            req.setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        } catch (ServiceException e) {
            logger.error("Service Exception in ToMainCommand", e);
            req.setAttribute(StringAttribute.E, e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
