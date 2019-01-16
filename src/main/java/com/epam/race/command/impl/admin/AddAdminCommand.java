package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.entity.user.UserType;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.util.Encryption;
import com.epam.race.validation.SignUpValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddAdminCommand implements Command {
    private static Logger logger = LogManager.getLogger(AddAdminCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        User user = new User();

        user.setLogin(req.getParameter(StringAttribute.LOGIN));
        user.setEmail(req.getParameter(StringAttribute.EMAIL));
        user.setUserType(UserType.ADMIN);

        String password = req.getParameter(StringAttribute.PASSWORD);
        String confirmedPassword = req.getParameter(StringAttribute.CONFIRMED_PASSWORD);
        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttribute.PASSWORD));
        user.setPassword(encryptedPassword);

        try {
            SignUpValidator validator = new SignUpValidator();

            boolean flag = true;
            boolean loginIsPresent = validator.checkLoginIsPresent(user.getLogin());
            boolean loginIsCorrect = validator.checkLoginIsCorrect(user.getLogin());

            if (!loginIsPresent && loginIsCorrect) {
                req.setAttribute(StringAttribute.ADMIN_LOGIN, user.getLogin());
            } else {
                flag = false;
                if (loginIsPresent) {
                    req.setAttribute(StringAttribute.PRESENT_LOGIN, StringAttribute.TRUE);
                } else {
                    req.setAttribute(StringAttribute.INCORRECT_LOGIN, StringAttribute.TRUE);
                }
            }

            boolean isCorrectPassword = validator.checkPassword(password);
            if (isCorrectPassword) {

                req.setAttribute(StringAttribute.PASSWORD, password);

                boolean isPasswordsMatch = password.equals(confirmedPassword);
                if (isPasswordsMatch) {
                    req.setAttribute(StringAttribute.CONFIRMED_PASSWORD, confirmedPassword);
                } else {
                    flag = false;
                    req.setAttribute(StringAttribute.PASSWORDS_NOT_MATCH,
                            StringAttribute.TRUE);
                }

            } else {
                flag = false;
                req.setAttribute(StringAttribute.INCORRECT_PASSWORD,
                        StringAttribute.TRUE);
            }

            if (flag) {
                UserService userService = new UserService();
                userService.addUser(user);

                RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                List<Integer> attributes = raceService.mainAttributes();
                req.getSession().setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.getSession().setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());
                router.setRedirect();
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
            } else {
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_ADMIN_PAGE));
            }

        } catch (ServiceException e) {
            logger.error("Service exception in AddAdminCommand", e);
            req.setAttribute(StringAttribute.E, e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
