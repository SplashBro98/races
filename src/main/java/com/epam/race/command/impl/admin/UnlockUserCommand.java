package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.user.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UnlockUserCommand implements Command {
    private static Logger logger = LogManager.getLogger(UnlockUserCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String login = req.getParameter(StringAttribute.USER_LOGIN);

        try{
            UserService userService = new UserService();
            userService.unlockUser(login);
            List<User> users = userService.findAllUsers();
            req.getSession().setAttribute(StringAttribute.USERS,users);

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_USER_LIST_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in UnlockUserCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
