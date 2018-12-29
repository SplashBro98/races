package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Bet;
import com.epam.race.service.BetService;
import com.epam.race.service.ServiceException;
import com.epam.race.util.constant.StringAttributes;
import com.epam.race.util.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditBetCommand implements Command {
    private static Logger logger = LogManager.getLogger(EditBetCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String enteredCoeff = req.getParameter(StringAttributes.COEFF);
        boolean isCorrectCoeff  = new BetValidator().isCorrectCoeff(enteredCoeff);
        if(!isCorrectCoeff){
            req.setAttribute("incorrect_coeff","incorrect coefficient");
            return PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_BET_PAGE);
        }

        try{
            Bet bet = (Bet) req.getSession().getAttribute(StringAttributes.BET);
            double coeff = Double.parseDouble(enteredCoeff);
            BetService betService = new BetService();
            betService.updateBetCoeff(bet.getBetId(), coeff);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("service error or lower",e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}