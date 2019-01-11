package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;

import javax.servlet.http.HttpServletRequest;

public class PaginationCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        int currentPage = Integer.parseInt(req.getParameter(StringAttributes.CURRENT_PAGE));

        RaceService raceService = new RaceService(currentPage,8);

        req.getSession().setAttribute(StringAttributes.RACES,raceService.findCurrentRaces());

        req.getSession().setAttribute(StringAttributes.CURRENT_PAGE,raceService.getCurrentPage());
        req.getSession().setAttribute(StringAttributes.NUMBER_OF_PAGES, raceService.getNumberOfPages());

        return PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);

    }
}
