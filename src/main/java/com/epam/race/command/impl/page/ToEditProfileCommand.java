package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttribute;
import com.epam.race.entity.user.User;
import com.epam.race.servlet.Router;
import com.epam.race.util.Encryption;

import javax.servlet.http.HttpServletRequest;

public class ToEditProfileCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        User user = (User) req.getSession().getAttribute(StringAttribute.USER);
        String realPassword = Encryption.decrypt(user.getPassword());
        user.setPassword(realPassword);
        req.getSession().setAttribute(StringAttribute.USER, user);

        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_PROFILE_PAGE));
        return router;
    }
}
