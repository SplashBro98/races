package com.epam.race.command.impl.page;

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

public class ToUserListCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToUserListCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        try{
            UserService userService = new UserService();
            List<User> users = userService.findAllUsers();

            req.setAttribute(StringAttribute.USERS,users);

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_USER_LIST_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToUserListCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
