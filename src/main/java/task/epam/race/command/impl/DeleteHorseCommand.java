package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.Horse;
import task.epam.race.repository.HorseRepository;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteHorseCommand {

//    @Override
//    public String execute(HttpServletRequest req) {
//        String page;
//
//        String name = req.getParameter("name");
//        try{
//            HorseRepository.getInstance().remove(new Horse(name));
//            req.setAttribute("horses",HorseRepository.getInstance().query(
//                    new SelectAllHorsesSpecification()));
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//
//        }catch (SQLException e){
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
//    }
}
