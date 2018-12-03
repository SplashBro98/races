package task.epam.race.command.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.service.MainPageService;
import task.epam.race.service.UserService;
import task.epam.race.util.constant.StringAttributes;
import task.epam.race.util.constant.StringConstant;
import task.epam.race.util.encryption.Encryption;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter(StringAttributes.LOGIN);
        String password = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        String page;

        try {
           boolean isPresent = new UserService().findUser(login, password);

            if (isPresent) {

                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);

                req.getSession().setAttribute(StringAttributes.LOGIN,login);
                new MainPageService().setAttributes(req);

            }
            else {
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
                req.setAttribute("incorrect", StringAttributes.ATTRIBUTE_WRONG_EMAIL_OR_PASSWORD);
            }

        } catch (SQLException e) {
            logger.error("problem with service layer or lower", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
//        SQLSpecification specification = new SelectUserSpecification(login, password);
//
//        String page;
//        try {
//            List<User> users = UserRepository.getInstance().query(specification);
//            if(!users.isEmpty()){
//                new MainPageService().setAttributes(req);
//                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//            }else {
//                req.setAttribute("incorrect","Incorrect login or password");
//                page = PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
//            }
//        } catch (SQLException e) {
//            //req.setAttribute();
//            e.printStackTrace();
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
    }
}
