package task.epam.race.command.impl;


import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.User;
import task.epam.race.entity.UserType;
import task.epam.race.service.MainPageService;
import task.epam.race.service.RaceService;
import task.epam.race.service.UserService;
import task.epam.race.util.constant.StringAttributes;
import task.epam.race.util.constant.StringConstant;
import task.epam.race.util.encryption.Encryption;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


/**
 * @author Ivan Mazaliuk
 *
 */
public class SignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        User user = new User();
        user.setName(req.getParameter(StringAttributes.NAME));
        user.setSurname(req.getParameter(StringAttributes.SURNAME));
        user.setLogin(req.getParameter(StringAttributes.LOGIN));
        user.setEmail(req.getParameter(StringAttributes.EMAIL));

        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        user.setPassword(encryptedPassword);
        String userType = req.getParameter("type").replace(' ','_').toUpperCase();
        user.setUserType(UserType.valueOf(userType));


        String page;
        try {
            boolean success = new UserService().addUser(user);

            if(success) {
                req.getSession().setAttribute(StringAttributes.LOGIN, req.getParameter(StringAttributes.LOGIN));
                req.setAttribute("races",new RaceService().findAllRaces());
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            }else {
                req.setAttribute("incorrect_login","User with this login is already exists");
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_SIGN_UP_PAGE);
            }
        }catch (SQLException e){
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
