package task.epam.race.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.service.UserService;

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
