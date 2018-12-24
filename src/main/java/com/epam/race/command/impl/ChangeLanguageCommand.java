package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {




    @Override
    public String execute(HttpServletRequest req) {
        String newLocale = req.getParameter(StringAttributes.LOCALE);
        req.getSession().setAttribute(StringAttributes.LOCALE,newLocale);
        return req.getSession().getAttribute(StringAttributes.PAGE).toString();
    }
}
