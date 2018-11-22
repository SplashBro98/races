package task.epam.race.command.impl;


import task.epam.race.command.Command;
import task.epam.race.entity.Horse;
import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.HorseRepository;
import task.epam.race.repository.UserRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;
import task.epam.race.specification.user.SelectUserSpecification;
import task.epam.race.util.encryption.Encryption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = Encryption.encrypt(req.getParameter("password"));
        SQLSpecification specification = new SelectUserSpecification(login, password);

        String page;
        try {
            List<User> users = new UserRepository().query(specification);
            if(!users.isEmpty()){
                List<Horse> horses = new HorseRepository().query(new SelectAllHorsesSpecification());
                req.setAttribute("horses",horses);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
            }else {
                req.setAttribute("incorrect","Incorrect login or password");
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
