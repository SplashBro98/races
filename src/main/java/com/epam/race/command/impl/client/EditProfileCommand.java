package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.entity.user.UserType;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.Encryption;
import com.epam.race.validation.SignUpValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class EditProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(EditProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req) {

        String page;

        User user = (User) req.getSession().getAttribute(StringAttributes.USER);
        req.getSession().removeAttribute(StringAttributes.USER);


        user.setName(req.getParameter(StringAttributes.NAME));
        user.setSurname(req.getParameter(StringAttributes.SURNAME));
        user.setLogin(req.getParameter(StringAttributes.LOGIN));
        user.setEmail(req.getParameter(StringAttributes.EMAIL));
        user.setUserType(UserType.CLIENT);

        String password = req.getParameter(StringAttributes.PASSWORD);
        String confirmedPassword = req.getParameter(StringAttributes.CONFIRMED_PASSWORD);


        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        user.setPassword(encryptedPassword);


        try {
            SignUpValidator validator = new SignUpValidator();

            boolean flag = true;
            boolean loginIsCorrect = validator.checkLoginIsCorrect(user.getLogin());

            if (!loginIsCorrect) {

                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_LOGIN, StringAttributes.TRUE);
            }

            boolean emailIsCorrect = validator.checkEmail(user.getEmail());
            if (!emailIsCorrect) {

                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_EMAIL, StringAttributes.TRUE);

            }

            boolean isCorrectName = validator.checkName(user.getName());
            if (!isCorrectName) {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.TRUE);

            }

            boolean isCorrectSurname = validator.checkSurname(user.getSurname());
            if (!isCorrectSurname) {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_SURNAME, StringAttributes.TRUE);

            }

            boolean isCorrectPassword = validator.checkPassword(password);
            if (isCorrectPassword) {

                boolean isPasswordsMatch = password.equals(confirmedPassword);
                if (!isPasswordsMatch) {
                    flag = false;
                    req.setAttribute(StringAttributes.PASSWORDS_NOT_MATCH,
                            StringAttributes.TRUE);
                }
            } else {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_PASSWORD,
                        StringAttributes.TRUE);
            }
            req.getSession().setAttribute(StringAttributes.USER, user);
            if (flag) {

                req.getSession().setAttribute(StringAttributes.LOGIN, user.getLogin());
                req.getSession().setAttribute(StringAttributes.ROLE, user.getUserType().toString().toLowerCase());
                req.getSession().setAttribute(StringAttributes.LOCALE, Locale.getDefault());

                UserService userService = new UserService();
                userService.updateUser(user);
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE);
            } else {
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_PROFILE_PAGE);
            }

        } catch (ServiceException e) {
            logger.error("Service Exception in EditProfileCommand", e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
