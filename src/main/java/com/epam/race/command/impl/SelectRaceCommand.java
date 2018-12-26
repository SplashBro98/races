package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.BetService;
import com.epam.race.service.RaceService;
import com.epam.race.entity.Bet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class SelectRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        String raceName = req.getParameter("name");
        try {
            Optional<Race> maybeRace = new RaceService().findRace(raceName);
            if(maybeRace.isPresent()){
                Race race = maybeRace.get();
                List<Bet> bets = new BetService().findRaceBets(race.getRaceId());

                req.setAttribute("race",race);
                req.setAttribute("bets",bets);
            }else {
                req.setAttribute("nothing","race with this name doesn`t exist");
            }

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_RACE_PAGE);
        }catch (ServiceException e){
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
