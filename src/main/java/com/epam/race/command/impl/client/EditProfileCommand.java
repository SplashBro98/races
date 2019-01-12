package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.entity.user.UserType;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.StringConstant;
import com.epam.race.util.Encryption;
import com.epam.race.util.validation.SignUpValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
                req.setAttribute(StringAttributes.INCORRECT_LOGIN, StringAttributes.ATTRIBUTE_INCORRECT_LOGIN);
            }

            boolean emailIsCorrect = validator.checkEmail(user.getEmail());
            if (!emailIsCorrect) {

                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_EMAIL, StringAttributes.ATTRIBUTE_INCORRECT_EMAIL);

            }

            boolean isCorrectName = validator.checkName(user.getName());
            if (!isCorrectName) {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_NAME, StringAttributes.ATTRIBUTE_INCORRECT_NAME);

            }

            boolean isCorrectSurname = validator.checkSurname(user.getSurname());
            if (!isCorrectSurname) {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_SURNAME, StringAttributes.ATTRIBUTE_INCORRECT_SURNAME);

            }

            boolean isCorrectPassword = validator.checkPassword(password);
            if (isCorrectPassword) {

                boolean isPasswordsMatch = password.equals(confirmedPassword);
                if (!isPasswordsMatch) {
                    flag = false;
                    req.setAttribute(StringAttributes.PASSWORDS_NOT_MATCH,
                            StringAttributes.ATTRIBUTE_PASSWORDS_NOT_MATCH);
                }
            } else {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_PASSWORD,
                        StringAttributes.ATTRIBUTE_INCORRECT_PASSWORD);
            }

            req.getSession().setAttribute(StringAttributes.USER, user);
            if (flag) {

                req.getSession().setAttribute(StringAttributes.LOGIN, user.getLogin());
                req.getSession().setAttribute(StringAttributes.ROLE, user.getUserType().toString().toLowerCase());
                req.getSession().setAttribute(StringAttributes.LOCALE, Locale.getDefault());

                new UserService().updateUser(user);
                RaceService raceService = new RaceService(1, 5);
                List<Object> attributes = raceService.mainAttributes();

                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));

                req.getSession().setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());
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