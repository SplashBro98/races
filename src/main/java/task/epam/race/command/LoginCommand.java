package task.epam.race.command;

import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.UserRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.SelectUserSpecification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest req) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        SQLSpecification specification = new SelectUserSpecification(login, password);
        String page = null;
        try {
            List<User> users = new UserRepository().query(specification);
            if(!users.isEmpty()){
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
            }else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_FAIL_PAGE);
            }
        } catch (SQLException e) {

        }
        return page;
    }
}
