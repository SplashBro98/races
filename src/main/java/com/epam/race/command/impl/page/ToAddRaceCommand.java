package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.ServiceException;
import com.epam.race.service.HorseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToAddRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToAddRaceCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        try{
            List<String> horseNames = new HorseService().findHorseNames();
            req.getSession().setAttribute("horseNames",horseNames);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_RACE_PAGE);
        }catch (ServiceException e){
            logger.error("sdfsdfs",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
