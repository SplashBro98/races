package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;

import javax.servlet.http.HttpServletRequest;

public class ToEnterSumCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String betId =  req.getParameter("betId");
        req.getSession().setAttribute("betId",betId);
        return PageManager.INSTANCE.getProperty(PageManager.PATH_ENTER_SUM_PAGE);
    }
}
