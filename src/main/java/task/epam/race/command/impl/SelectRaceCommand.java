package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.Bet;
import task.epam.race.entity.Race;
import task.epam.race.repository.HorseRepository;
import task.epam.race.repository.RaceRepository;
import task.epam.race.service.BetService;
import task.epam.race.service.RaceService;
import task.epam.race.specification.horse.SelectHorseByRaceSpecification;
import task.epam.race.specification.race.SelectAllRacesSpecification;
import task.epam.race.specification.race.SelectRaceByNameSpecification;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SelectRaceCommand implements Command{

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
        }catch (SQLException e){
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
