package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Bet;
import com.epam.race.service.ServiceException;
import com.epam.race.service.BetService;
import com.epam.race.service.RaceService;

import javax.servlet.http.HttpServletRequest;

public class AddBetCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String raceName = req.getParameter("raceName");
        String describe = req.getParameter("describe");
        double coeff = Double.parseDouble(req.getParameter("coeff"));
        try{
            int raceId = new RaceService().findRaceId(raceName);
            Bet bet = new Bet(raceId, describe, coeff);
            new BetService().addBet(bet);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
