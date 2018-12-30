package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToUserListCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToUserListCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        try{
            UserService userService = new UserService();
            List<User> users = userService.findAllUsers();

            req.getSession().setAttribute("users",users);


            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_LIST_PAGE);
        }catch (ServiceException e){
            logger.error("service error",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
