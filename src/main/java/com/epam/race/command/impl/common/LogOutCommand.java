package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        req.getSession().invalidate();
        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE));
        return router;
    }
}
