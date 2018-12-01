package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.entity.Horse;
import task.epam.race.repository.HorseRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteHorseCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String name = req.getParameter("name");
        try{
            HorseRepository.getInstance().remove(new Horse(name));
            req.setAttribute("horses",HorseRepository.getInstance().query(
                    new SelectAllHorsesSpecification()));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);

        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
