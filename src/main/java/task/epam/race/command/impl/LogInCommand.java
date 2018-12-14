package task.epam.race.command.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.User;
import task.epam.race.service.MainPageService;
import task.epam.race.service.RaceService;
import task.epam.race.service.UserService;
import task.epam.race.util.constant.StringAttributes;
import task.epam.race.util.constant.StringConstant;
import task.epam.race.util.encryption.Encryption;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Optional;


public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter(StringAttributes.LOGIN);
        String password = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        String page;

        try {
           Optional<User> maybeUser = new UserService().findUser(login, password);

            if (maybeUser.isPresent()) {

                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);

                String role = maybeUser.get().getUserType().toString().toLowerCase();

                req.getSession().setAttribute("role",role);
                req.getSession().setAttribute("locale", Locale.getDefault());
                req.getSession().setAttribute(StringAttributes.LOGIN,login);
                req.getSession().setAttribute("races",new RaceService().findAllRaces());

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
//        SQLSpecification specification = new SelectUserByLoginAndPasswordSpecification(login, password);
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
