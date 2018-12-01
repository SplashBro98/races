package task.epam.race.command.impl.auth;


import task.epam.race.command.Command;
import task.epam.race.service.MainPageService;
import task.epam.race.service.UserService;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.util.constant.StringConstant;
import task.epam.race.util.encryption.Encryption;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class LogInCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter(StringConstant.LOGIN);
        String password = Encryption.encrypt(req.getParameter(StringConstant.PASSWORD));
        String page;

        try {
            page = new UserService().findUser(login, password);

            if (page.equals(ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE))) {

                req.getSession().setAttribute(StringConstant.LOGIN,login);
                new MainPageService().setAttributes(req);

            }
            if (page.equals(ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE))) {
                req.setAttribute("incorrect", StringConstant.ATTRIBUTE_WRONG_EMAIL_OR_PASSWORD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
//        SQLSpecification specification = new SelectUserSpecification(login, password);
//
//        String page;
//        try {
//            List<User> users = UserRepository.getInstance().query(specification);
//            if(!users.isEmpty()){
//                new MainPageService().setAttributes(req);
//                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
//            }else {
//                req.setAttribute("incorrect","Incorrect login or password");
//                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE);
//            }
//        } catch (SQLException e) {
//            //req.setAttribute();
//            e.printStackTrace();
//            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
//        }
//        return page;
    }
}
