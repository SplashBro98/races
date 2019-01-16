package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.servlet.Router;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.util.Encryption;
import com.epam.race.validation.LoginValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String login = req.getParameter(StringAttribute.LOGIN);
        String password = req.getParameter(StringAttribute.PASSWORD);
        LoginValidator loginValidator = new LoginValidator();
        if (!loginValidator.checkLogInInfo(login, password)) {
            req.setAttribute(StringAttribute.INCORRECT, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE));
            return router;
        }
        password = Encryption.encrypt(password);

        try {
            Optional<User> maybeUser = new UserService().findUser(login, password);

            if (maybeUser.isPresent()) {

                User user = maybeUser.get();
                if (user.getIsLocked()) {
                    req.setAttribute(StringAttribute.BLOCKED, StringAttribute.TRUE);
                    router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE));
                    return router;
                }

                String role = user.getUserType().toString().toLowerCase();

                req.getSession().setAttribute(StringAttribute.ROLE, role);
                req.getSession().setAttribute(StringAttribute.LOCALE, req.getParameter(StringAttribute.LOCALE));
                req.getSession().setAttribute(StringAttribute.LOGIN, login);

                RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                List<Object> attributes = raceService.mainAttributes();
                req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.setAttribute(StringAttribute.RACES, raceService.findCurrentRaces());

                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
            } else {
                req.setAttribute(StringAttribute.INCORRECT, StringAttribute.TRUE);
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE));
            }

        } catch (ServiceException e) {
            logger.error("Service Exception in LogInCommand", e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
