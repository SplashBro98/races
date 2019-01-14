package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttributes;
import com.epam.race.util.IntegerConstant;

import javax.servlet.http.HttpServletRequest;

public class PaginationCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        int currentPage = Integer.parseInt(req.getParameter(StringAttributes.CURRENT_PAGE));
        RaceService raceService = new RaceService(currentPage, IntegerConstant.COUNT_OF_RACES);
        req.setAttribute(StringAttributes.RACES,raceService.findCurrentRaces());
        req.setAttribute(StringAttributes.CURRENT_PAGE,raceService.getCurrentPage());
        req.setAttribute(StringAttributes.NUMBER_OF_PAGES, raceService.getNumberOfPages());

        return PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
    }
}
