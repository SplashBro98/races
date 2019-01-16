package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public class ToEnterSumCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        String betId =  req.getParameter(StringAttribute.BET_ID);
        req.getSession().setAttribute(StringAttribute.BET_ID,betId);
        String betCoeff = req.getParameter(StringAttribute.COEFF);
        req.getSession().setAttribute(StringAttribute.COEFF,betCoeff);

        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE));
        return router;
    }
}
