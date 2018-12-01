package task.epam.race.service;

import task.epam.race.entity.User;
import task.epam.race.repository.UserRepository;
import task.epam.race.servlet.ConfigurationManager;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.SelectUserSpecification;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public String findUser(String login, String password) throws SQLException {

        SQLSpecification specification = new SelectUserSpecification(login, password);
        List<User> users = UserRepository.getInstance().query(specification);
        String page;
        if (!users.isEmpty()) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_MAIN_PAGE);
        } else {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigurationManager.PATH_LOGIN_PAGE);
        }
        return page;
    }

}
