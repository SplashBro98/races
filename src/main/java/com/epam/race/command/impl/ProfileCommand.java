package com.epam.race.command.impl;

import com.epam.race.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(ProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
//        String page;
//        try{
//            User user = new UserService().findUserByLogin(req.getParameter("login"));
//            req.setAttribute("user",user);
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE);
//        }catch (RepositoryException e){
//            logger.error("adfsdfsa", e);
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
        return null;
    }
}
