package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.command.StringAttributes;

import javax.servlet.http.HttpServletRequest;

public class ToProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        try{
            String login = req.getSession().getAttribute(StringAttributes.LOGIN).toString();
            User user = new UserService().findUserByLogin(login);
            req.getSession().setAttribute(StringAttributes.USER,user);


            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE);
        }catch (ServiceException e){
            logger.error("Error in service or lower");
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
