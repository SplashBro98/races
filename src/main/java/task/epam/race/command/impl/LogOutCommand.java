package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        req.getSession().invalidate();
        return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
    }
}
