package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.User;
import com.epam.race.entity.UserBet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import com.epam.race.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToProfileCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToProfileCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        try{
            String login = req.getSession().getAttribute(StringAttributes.LOGIN).toString();
            User user = new UserService().findUserByLogin(login);
            req.setAttribute("user",user);
            List<UserBet> userBets = new UserBetService().findUserBets(login);
            if(userBets.isEmpty()){
                req.setAttribute("nothing","You haven`t any bets at the moment");
            }
            req.setAttribute("userBets",userBets);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_PROFILE_PAGE);
        }catch (ServiceException e){
            logger.error("Error in service or lower");
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
