package com.epam.race.command.impl.common;


import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.util.IntegerConstant;
import com.epam.race.util.StringConstant;
import com.epam.race.util.Encryption;
import com.epam.race.validation.LoginValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String login = req.getParameter(StringAttributes.LOGIN);
        String password = req.getParameter(StringAttributes.PASSWORD);
        LoginValidator loginValidator = new LoginValidator();
        if (!loginValidator.checkLogInInfo(login, password)) {
            req.setAttribute(StringAttributes.INCORRECT, StringAttributes.TRUE);
            return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
        }

        password = Encryption.encrypt(password);

        try {
            Optional<User> maybeUser = new UserService().findUser(login, password);

            if (maybeUser.isPresent()) {

                User user = maybeUser.get();
                if (user.getIsLocked()) {
                    req.setAttribute(StringAttributes.BLOCKED, StringAttributes.TRUE);
                    return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
                }

                String role = user.getUserType().toString().toLowerCase();

                req.getSession().setAttribute(StringAttributes.ROLE, role);
                req.getSession().setAttribute(StringAttributes.LOCALE, req.getParameter(StringAttributes.LOCALE));
                req.getSession().setAttribute(StringAttributes.LOGIN, login);

                RaceService raceService = new RaceService(IntegerConstant.START_PAGE,
                        IntegerConstant.COUNT_OF_RACES);
                List<Object> attributes = raceService.mainAttributes();
                req.setAttribute(StringConstant.CURRENT_PAGE, attributes.get(0));
                req.setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));
                req.setAttribute(StringAttributes.RACES, raceService.findCurrentRaces());
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            } else {
                req.setAttribute(StringAttributes.INCORRECT, StringAttributes.TRUE);
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
            }

        } catch (ServiceException e) {
            logger.error("Service Exception in LogInCommand", e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
