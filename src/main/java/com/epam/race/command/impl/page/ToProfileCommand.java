package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.command.StringAttribute;

import javax.servlet.http.HttpServletRequest;

public class ToProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToProfileCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        try{
            String login = req.getSession().getAttribute(StringAttribute.LOGIN).toString();
            UserService userService = new UserService();
            User user = userService.findUserByLogin(login);
            req.getSession().setAttribute(StringAttribute.USER,user);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToProfileCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
