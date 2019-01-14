package com.epam.race.command.impl.client;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.user.UserBet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import com.epam.race.service.UserService;
import com.epam.race.command.StringAttributes;
import com.epam.race.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.MathContext;

public class EnterSumCommand implements Command {
    private static Logger logger = LogManager.getLogger(EnterSumCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String strSum = req.getParameter(StringAttributes.SUM);

        boolean isCorrectSum = new BetValidator().isCorrectSum(strSum);

        if(!isCorrectSum){
            req.setAttribute(StringAttributes.INCORRECT_SUM,StringAttributes.TRUE);
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE);
        }

        try{
            UserService service = new UserService();
            String login = req.getSession().getAttribute(StringAttributes.LOGIN).toString();
            BigDecimal sumOfBet = new BigDecimal(strSum).round(new MathContext(4));
            BigDecimal userAmount = service.findUserAmount(login);
            if(userAmount.compareTo(sumOfBet) == -1){
                req.setAttribute(StringAttributes.INCORRECT_SUM,StringAttributes.TRUE);
                return PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE);
            }

            UserBetService userBetService = new UserBetService();
            int betId = Integer.parseInt(req.getSession().getAttribute(StringAttributes.BET_ID).toString());
            double coeff = Double.parseDouble(req.getSession().getAttribute(StringAttributes.COEFF).toString());

            service.updateUserAmount(login,userAmount.subtract(
                    sumOfBet).round(new MathContext(4)));
            userBetService.addUserBet(new UserBet(betId,login,sumOfBet,coeff));

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);

        }catch (ServiceException e){
            logger.error("Service Exception in EnterSumCommand", e);
            req.setAttribute(StringAttributes.E,e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }

        return page;
    }
}
