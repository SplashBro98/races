package com.epam.race.command.impl.common;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.util.IntegerConstant;

import javax.servlet.http.HttpServletRequest;

public class PaginationCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        int currentPage = Integer.parseInt(req.getParameter(StringAttribute.CURRENT_PAGE));
        RaceService raceService = new RaceService(currentPage, IntegerConstant.COUNT_OF_RACES);
        req.setAttribute(StringAttribute.RACES,raceService.findCurrentRaces());
        req.setAttribute(StringAttribute.CURRENT_PAGE,raceService.getCurrentPage());
        req.setAttribute(StringAttribute.NUMBER_OF_PAGES, raceService.getNumberOfPages());

        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE));
        return router;
    }
}
