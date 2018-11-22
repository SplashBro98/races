package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.CommandMap;
import task.epam.race.entity.Horse;
import task.epam.race.repository.HorseRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddHorseCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        Horse horse = new Horse();
        horse.setName(req.getParameter("name"));
        horse.setAge(Integer.parseInt(req.getParameter("age")));
        horse.setWins(Integer.parseInt(req.getParameter("wins")));

        String page;
        try{
            new HorseRepository().add(horse);
            List<Horse> horses = new HorseRepository().query(new SelectAllHorsesSpecification());
            req.setAttribute("horses",horses);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
