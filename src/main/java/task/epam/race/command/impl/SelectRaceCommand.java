package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.entity.Race;
import task.epam.race.repository.HorseRepository;
import task.epam.race.repository.RaceRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.horse.SelectHorseByRaceSpecification;
import task.epam.race.specification.race.SelectAllRacesSpecification;
import task.epam.race.specification.race.SelectRaceByNameSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        String name = req.getParameter("name");
        try {
            List<Race> races = RaceRepository.getInstance().query(new SelectRaceByNameSpecification(name));
            if(!races.isEmpty()){
                req.setAttribute("race",races.get(0));
                req.setAttribute("horses",HorseRepository.getInstance().
                        query(new SelectHorseByRaceSpecification(races.get(0))));
            }else {
                req.setAttribute("nothing","race with this name doesn`t exist");
            }
            List<Race> allRaces = RaceRepository.getInstance().query(new SelectAllRacesSpecification());
            req.setAttribute("allRaces",allRaces);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
