package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        String newLocale = req.getParameter(StringAttribute.LOCALE);
        req.getSession().setAttribute(StringAttribute.LOCALE,newLocale);
        router.setPage(req.getSession().getAttribute(StringAttribute.PAGE).toString());
        return router;
    }
}
