package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;

import javax.servlet.http.HttpServletRequest;

public class ToEnterSumCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String betId =  req.getParameter(StringAttributes.BET_ID);
        req.getSession().setAttribute(StringAttributes.BET_ID,betId);
        String betCoeff = req.getParameter(StringAttributes.COEFF);
        req.getSession().setAttribute(StringAttributes.COEFF,betCoeff);
        return PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE);
    }
}
