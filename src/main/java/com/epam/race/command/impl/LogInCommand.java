package com.epam.race.command.impl;


import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.User;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserService;
import com.epam.race.util.constant.StringConstant;
import com.epam.race.util.encryption.Encryption;
import com.epam.race.util.validation.LoginValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.service.RaceService;
import com.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


public class LogInCommand implements Command {
    private static Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter(StringAttributes.LOGIN);
        String password = req.getParameter(StringAttributes.PASSWORD);


        LoginValidator loginValidator = new LoginValidator();
        if(!loginValidator.checkLogInInfo(login, password)){
            req.setAttribute(StringAttributes.INCORRECT, StringAttributes.ATTRIBUTE_WRONG_EMAIL_OR_PASSWORD);
            return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
        }

        password = Encryption.encrypt(password);
        String page;
        try {
           Optional<User> maybeUser = new UserService().findUser(login, password);

            if (maybeUser.isPresent()) {

                String role = maybeUser.get().getUserType().toString().toLowerCase();

                req.getSession().setAttribute(StringAttributes.ROLE,role);
                req.getSession().setAttribute(StringAttributes.LOCALE, Locale.getDefault());
                req.getSession().setAttribute(StringAttributes.LOGIN,login);

                RaceService raceService = new RaceService(1,5);
                List<Object> attributes = raceService.mainAttributes();

                req.getSession().setAttribute(StringConstant.CURRENT_PAGE,attributes.get(0));
                req.getSession().setAttribute(StringConstant.NUMBER_OF_PAGES, attributes.get(1));

                req.getSession().setAttribute(StringAttributes.RACES,raceService.findCurrentRaces());

                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            }
            else {
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
                req.setAttribute(StringAttributes.INCORRECT, StringAttributes.ATTRIBUTE_WRONG_EMAIL_OR_PASSWORD);
            }

        } catch (ServiceException e) {
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
