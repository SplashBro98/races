package task.epam.race.service;

import task.epam.race.entity.User;
import task.epam.race.repository.UserRepository;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.SelectUserSpecification;
import task.epam.race.util.validation.SignUpValidator;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public boolean findUser(String login, String password) throws SQLException {

        //TODO когда и где помещать в req все аттрибуты, которые нужны для страницы
        SQLSpecification specification = new SelectUserSpecification(login, password);
        List<User> users = UserRepository.getInstance().query(specification);
        return !users.isEmpty();
    }

    public boolean addUser(User user) throws SQLException{
        SignUpValidator validator = new SignUpValidator();
        boolean result = false;
        if(validator.checkLogin(user.getLogin())){
            UserRepository.getInstance().add(user);
            result = true;
        }
        return result;
    }

}
