package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.UserBet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.MathContext;

public class EnterSumCommand implements Command {
    private static Logger logger = LogManager.getLogger(EnterSumCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String strSum = req.getParameter(StringAttribute.SUM);

        boolean isCorrectSum = new BetValidator().isCorrectSum(strSum);

        if(!isCorrectSum){
            req.setAttribute(StringAttribute.INCORRECT_SUM, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE));
            return router;
        }

        try{
            UserService service = new UserService();
            String login = req.getSession().getAttribute(StringAttribute.LOGIN).toString();
            BigDecimal sumOfBet = new BigDecimal(strSum);
            BigDecimal userAmount = service.findUserAmount(login);
            if(userAmount.compareTo(sumOfBet) == -1){
                req.setAttribute(StringAttribute.INCORRECT_SUM, StringAttribute.TRUE);
                router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE));
                return router;
            }

            UserBetService userBetService = new UserBetService();
            int betId = Integer.parseInt(req.getSession().getAttribute(StringAttribute.BET_ID).toString());
            double coeff = Double.parseDouble(req.getSession().getAttribute(StringAttribute.COEFF).toString());

            service.updateUserAmount(login,userAmount.subtract(
                    sumOfBet).round(new MathContext(4)));
            userBetService.addUserBet(new UserBet(betId,login,sumOfBet,coeff));

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in EnterSumCommand", e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
