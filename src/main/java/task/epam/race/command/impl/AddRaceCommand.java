package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.entity.Race;
import task.epam.race.repository.RaceRepository;
import task.epam.race.service.MainPageService;
import task.epam.race.servlet.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddRaceCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        Race race = new Race();
        race.setName(req.getParameter("name"));
        race.setPlace(req.getParameter("place"));
        race.setDate(LocalDate.parse(req.getParameter("date")));
        race.setTime(LocalTime.parse(req.getParameter("time")));

        String page;
        try{
            RaceRepository.getInstance().add(race);

            new MainPageService().setAttributes(req);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;

    }
}
