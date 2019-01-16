package com.epam.race.command.impl.bookmaker;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Bet;
import com.epam.race.service.BetService;
import com.epam.race.service.ServiceException;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditBetCommand implements Command {
    private static Logger logger = LogManager.getLogger(EditBetCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String enteredCoeff = req.getParameter(StringAttribute.COEFF);
        boolean isCorrectCoeff  = new BetValidator().isCorrectCoeff(enteredCoeff);
        if(!isCorrectCoeff){
            req.setAttribute(StringAttribute.INCORRECT_COEFF, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_BET_PAGE));
            return router;
        }

        try{
            Bet bet = (Bet) req.getSession().getAttribute(StringAttribute.BET);
            double coeff = Double.parseDouble(enteredCoeff);
            BetService betService = new BetService();
            betService.updateBetCoeff(bet.getBetId(), coeff);

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in EditBetCommand",e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
