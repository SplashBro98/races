package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.entity.Horse;
import task.epam.race.repository.HorseRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.horse.SelectHorseSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectHorseCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String page;
        String name = req.getParameter("name");
        try {
            List<Horse> horses = HorseRepository.getInstance().query(new SelectHorseSpecification(name));
            if(!horses.isEmpty()){
                req.setAttribute("horse",horses.get(0));
            }else {
                req.setAttribute("nothing","Horse with this name doesn`t exist");
            }
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
        }catch (SQLException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
