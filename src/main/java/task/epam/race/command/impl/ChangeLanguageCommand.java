package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;

import javax.servlet.http.HttpServletRequest;

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String newLocale = req.getParameter("locale");
        req.getSession().setAttribute("locale",newLocale);
        return req.getSession().getAttribute("page").toString();
    }
}
