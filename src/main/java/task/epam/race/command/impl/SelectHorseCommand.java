package task.epam.race.command.impl;

import task.epam.race.command.Command;
import task.epam.race.command.PageManager;
import task.epam.race.entity.Horse;
import task.epam.race.repository.HorseRepository;
import task.epam.race.specification.horse.SelectHorseByNameSpecification;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class SelectHorseCommand  {

//    @Override
//    public String execute(HttpServletRequest req){
//        String page;
//        String name = req.getParameter("name");
//        try {
//            List<Horse> horses = HorseRepository.getInstance().query(new SelectHorseByNameSpecification(name));
//            if(!horses.isEmpty()){
//                req.setAttribute("horse",horses.get(0));
//            }else {
//                req.setAttribute("nothing","Horse with this name doesn`t exist");
//            }
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
//        }catch (SQLException e){
//            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
//        }
//        return page;
//    }
}
