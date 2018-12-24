package com.epam.race.command.impl;


import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.User;
import com.epam.race.entity.UserType;
import com.epam.race.exception.ServiceException;
import com.epam.race.service.RaceService;
import com.epam.race.service.UserService;
import com.epam.race.util.constant.StringAttributes;
import com.epam.race.util.encryption.Encryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;


/**
 * @author Ivan Mazaliuk
 *
 */
public class SignUpCommand implements Command {
    private static Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest req) {

        String page;
        User user = new User();


        user.setName(req.getParameter(StringAttributes.NAME));
        user.setSurname(req.getParameter(StringAttributes.SURNAME));
        user.setLogin(req.getParameter(StringAttributes.LOGIN));
        user.setEmail(req.getParameter(StringAttributes.EMAIL));
        user.setUserType(UserType.CLIENT);

        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");


        String encryptedPassword = Encryption.encrypt(req.getParameter(StringAttributes.PASSWORD));
        user.setPassword(encryptedPassword);


        try {
            boolean success = new UserService().addUser(user);

            if(success) {
                req.getSession().setAttribute(StringAttributes.LOGIN, user.getLogin());
                req.getSession().setAttribute(StringAttributes.ROLE, user.getUserType().toString());
                req.getSession().setAttribute(StringAttributes.LOCALE, Locale.getDefault());

                RaceService raceService = new RaceService(1,5);
                List<Object> attributes = raceService.mainAttributes();

                req.getSession().setAttribute("currentPage",attributes.get(0));
                req.getSession().setAttribute("numberOfPages", attributes.get(1));

                req.getSession().setAttribute(StringAttributes.RACES,raceService.findCurrentRaces());

                page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
            }else {
                req.setAttribute(StringAttributes.NAME,user.getName());
                req.setAttribute(StringAttributes.SURNAME,user.getSurname());
                req.setAttribute(StringAttributes.PASSWORD,password);
                req.setAttribute(StringAttributes.CONFIRMED_PASSWORD,confirmedPassword);
                req.setAttribute(StringAttributes.EMAIL,user.getEmail());
                req.setAttribute(StringAttributes.INCORRECT_LOGIN,StringAttributes.ATTRIBUTE_INCORRECT_LOGIN);
                page = PageManager.INSTANCE.getProperty(PageManager.PATH_SIGN_UP_PAGE);
            }
        }catch (ServiceException e){
            logger.error("Problem with command or lower", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
