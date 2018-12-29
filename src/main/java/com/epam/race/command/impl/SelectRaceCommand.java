package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Horse;
import com.epam.race.entity.Race;
import com.epam.race.service.ServiceException;
import com.epam.race.service.BetService;
import com.epam.race.service.RaceService;
import com.epam.race.entity.Bet;
import com.epam.race.util.constant.StringAttributes;
import com.sun.jdi.connect.Connector;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SelectRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        String raceName = req.getParameter(StringAttributes.NAME);
        try {
            Optional<Race> maybeRace = new RaceService().findRace(raceName);
            if(maybeRace.isPresent()){
                Race race = maybeRace.get();
                RaceService service = new RaceService();
                List<Bet> bets = new ArrayList<>();
                List<Horse> horses = new ArrayList<>();
                List<String> horseNames = service.findRaceBetsAndHorses(race.getRaceId(), bets, horses);

                req.getSession().setAttribute(StringAttributes.RACE,race);
                req.getSession().setAttribute(StringAttributes.BETS,bets);
                req.getSession().setAttribute(StringAttributes.HORSES,horses);
                req.getSession().setAttribute(StringAttributes.HORSE_NAMES,horseNames);
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
