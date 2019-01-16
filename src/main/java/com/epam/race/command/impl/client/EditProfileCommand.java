package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.entity.user.UserType;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.util.Encryption;
import com.epam.race.validation.SignUpValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class EditProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(EditProfileCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {

        Router router = new Router();
        User user = (User) req.getSession().getAttribute(StringAttribute.USER);
        req.getSession().removeAttribute(StringAttribute.USER);

        user.setName(req.getParameter(StringAttribute.NAME));
        user.setSurname(req.getParameter(StringAttribute.SURNAME));
        user.setLogin(req.getParameter(StringAttribute.LOGIN));
        user.setEmail(req.getParameter(StringAttribute.EMAIL));
        user.setUserType(UserType.CLIENT);

        String password = req.getParameter(StringAttribute.PASSWORD);
        String confirmedPassword = req.getParameter(StringAttribute.CONFIRMED_PASSWORD);
        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttribute.PASSWORD));
        user.setPassword(encryptedPassword);

        try {
            SignUpValidator validator = new SignUpValidator();

            boolean flag = true;
            boolean loginIsCorrect = validator.checkLoginIsCorrect(user.getLogin());

            if (!loginIsCorrect) {

                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_LOGIN, StringAttribute.TRUE);
            }

            boolean isCorrectName = validator.checkName(user.getName());
            if (!isCorrectName) {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_NAME, StringAttribute.TRUE);

            }

            boolean isCorrectSurname = validator.checkSurname(user.getSurname());
            if (!isCorrectSurname) {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_SURNAME, StringAttribute.TRUE);

            }

            boolean isCorrectPassword = validator.checkPassword(password);
            if (isCorrectPassword) {

                boolean isPasswordsMatch = password.equals(confirmedPassword);
                if (!isPasswordsMatch) {
                    flag = false;
                    req.setAttribute(StringAttribute.PASSWORDS_NOT_MATCH,
                            StringAttribute.TRUE);
                }
            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_PASSWORD,
                        StringAttribute.TRUE);
            }
            req.getSession().setAttribute(StringAttribute.USER, user);
            if (flag) {

                req.getSession().setAttribute(StringAttribute.LOGIN, user.getLogin());
                req.getSession().setAttribute(StringAttribute.ROLE, user.getUserType().toString().toLowerCase());
                req.getSession().setAttribute(StringAttribute.LOCALE, Locale.getDefault());

                UserService userService = new UserService();
                userService.updateUser(user);
                router.setRedirect();
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE));
            } else {
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_PROFILE_PAGE));
            }

        } catch (ServiceException e) {
            logger.error("Service Exception in EditProfileCommand", e);
            req.setAttribute(StringAttribute.E, e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
