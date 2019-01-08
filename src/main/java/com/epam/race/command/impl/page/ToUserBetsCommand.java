package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;
import com.epam.race.entity.user.UserBet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToUserBetsCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToUserBetsCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        String login = req.getSession().getAttribute(StringAttributes.LOGIN).toString();

        try {
            List<UserBet> currentUserBets = new UserBetService().findCurrentUserBetsByLogin(login);

            if(currentUserBets.isEmpty()){
                req.setAttribute("nothing","You haven`t any bets at the moment");
            }
            req.setAttribute("currentUserBets",currentUserBets);

            List<UserBet> previousUserBets = new UserBetService().findPreviousUserBetsByLogin(login);

            if(!previousUserBets.isEmpty()){
                req.setAttribute("previousUserBets",previousUserBets);
            }


            page = PageManager.INSTANCE.getProperty(PageManager.PATH_USER_BETS_PAGE);
        }catch (ServiceException e){
            logger.error("service exception in ToUserBetsCommand",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
