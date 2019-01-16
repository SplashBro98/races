package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public class ToSignUpCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_SIGN_UP_PAGE));
        return router;
    }
}
