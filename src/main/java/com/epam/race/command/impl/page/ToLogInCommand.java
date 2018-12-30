package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;

import javax.servlet.http.HttpServletRequest;

public class ToLogInCommand implements Command {

    @Override
    public String execute(HttpServletRequest req){
        return PageManager.INSTANCE.getProperty(PageManager.PATH_LOGIN_PAGE);
    }
}
