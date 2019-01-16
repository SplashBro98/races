package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.service.ServiceException;
import com.epam.race.service.HorseService;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToAddRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToAddRaceCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        try{
            List<String> horseNames = new HorseService().findHorseNames();
            req.getSession().setAttribute(StringAttribute.HORSE_NAMES,horseNames);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToAddRaceCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
