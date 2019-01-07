package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToMainCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToMainCommand.class);


    @Override
    public String execute(HttpServletRequest req) {
        String page;
        try {
            RaceService service = new RaceService(1, 5);
            List<Object> attrs = service.mainAttributes();

            req.getSession().setAttribute("currentPage", attrs.get(0));
            req.getSession().setAttribute("numberOfPages", attrs.get(1));

            req.getSession().setAttribute(StringAttributes.RACES, service.findCurrentRaces());
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("problem with service layer or lower", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
