package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.command.StringAttributes;
import com.epam.race.entity.user.User;
import com.epam.race.util.Encryption;

import javax.servlet.http.HttpServletRequest;

public class ToEditProfileCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute(StringAttributes.USER);
        String realPassword = Encryption.decrypt(user.getPassword());
        user.setPassword(realPassword);
        return PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_PROFILE_PAGE);
    }
}
