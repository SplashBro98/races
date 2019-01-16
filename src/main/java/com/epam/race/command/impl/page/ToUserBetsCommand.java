package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.user.UserBet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import com.epam.race.servlet.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ToUserBetsCommand implements Command {
    private static Logger logger = LogManager.getLogger(ToUserBetsCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        String login = req.getSession().getAttribute(StringAttribute.LOGIN).toString();

        try {
            List<UserBet> currentUserBets = new UserBetService().findCurrentUserBetsByLogin(login);

            if(currentUserBets.isEmpty()){
                req.setAttribute(StringAttribute.NOTHING, StringAttribute.TRUE);
            }
            req.setAttribute(StringAttribute.CURRENT_USER_BETS,currentUserBets);

            List<UserBet> previousUserBets = new UserBetService().findPreviousUserBetsByLogin(login);

            if(!previousUserBets.isEmpty()){
                req.setAttribute(StringAttribute.PREVIOUS_USER_BETS,previousUserBets);
            }

            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_USER_BETS_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in ToUserBetsCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
