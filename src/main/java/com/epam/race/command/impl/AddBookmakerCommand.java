package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.User;
import com.epam.race.entity.UserType;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.util.constant.StringAttributes;
import com.epam.race.util.constant.StringConstant;
import com.epam.race.util.encryption.Encryption;
import com.epam.race.util.validation.SignUpValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddBookmakerCommand implements Command {
    private static Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest req) {

        String page;
        User user = new User();


        user.setLogin(req.getParameter(StringAttributes.LOGIN));
        user.setEmail(req.getParameter(StringAttributes.EMAIL));
        user.setUserType(UserType.BOOKMAKER);

        String password = req.getParameter(StringAttributes.PASSWORD);
        String confirmedPassword = req.getParameter(StringAttributes.CONFIRMED_PASSWORD);


        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        user.setPassword(encryptedPassword);


        try {
            SignUpValidator validator = new SignUpValidator();

            //TODO Надо ли проверять поля на наличие инфы на сервере
            boolean flag = true;
            boolean loginIsPresent = validator.checkLoginIsPresent(user.getLogin());
            boolean loginIsCorrect = validator.checkLoginIsCorrect(user.getLogin());

            if (!loginIsPresent && loginIsCorrect) {

                req.setAttribute(StringAttributes.BOOKMAKER_LOGIN, user.getLogin());
            } else {
                flag = false;
                if (loginIsPresent) {
                    req.setAttribute(StringAttributes.INCORRECT_LOGIN, StringAttributes.ATTRIBUTE_LOGIN_IS_PRESENT);
                } else {
                    req.setAttribute(StringAttributes.INCORRECT_LOGIN, StringAttributes.ATTRIBUTE_INCORRECT_LOGIN);
                }
            }

            boolean emailIsCorrect = validator.checkEmail(user.getEmail());
            if (emailIsCorrect) {

                req.setAttribute(StringAttributes.EMAIL, user.getEmail());
            } else {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_EMAIL, StringAttributes.ATTRIBUTE_INCORRECT_EMAIL);
            }


            boolean isCorrectPassword = validator.checkPassword(password);
            if (isCorrectPassword) {

                req.setAttribute(StringAttributes.PASSWORD, password);

                boolean isPasswordsMatch = password.equals(confirmedPassword);
                if(isPasswordsMatch){
                    req.setAttribute(StringAttributes.CONFIRMED_PASSWORD, confirmedPassword);
                }else {
                    flag = false;
                    req.setAttribute(StringAttributes.PASSWORDS_NOT_MATCH,
                            StringAttributes.ATTRIBUTE_PASSWORDS_NOT_MATCH);
                }

            } else {
                flag = false;
                req.setAttribute(StringAttributes.INCORRECT_PASSWORD,
                        StringAttributes.ATTRIBUTE_INCORRECT_PASSWORD);
            }

            if (flag) {


                new UserService().addUser(user);
                RaceService raceService = new RaceService(1, 5);
                List<Object> attributes = raceService.mainAttributes();

                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));

                req.getSession().setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            }
            else {
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BOOKMAKER_PAGE);
            }


        } catch (ServiceException e) {
            logger.error("Problem with command or lower", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
