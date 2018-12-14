package task.epam.race.service;

import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.UserRepository;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.SelectUserByLoginAndPasswordSpecification;
import task.epam.race.specification.user.SelectUserByLoginSpecification;
import task.epam.race.util.validation.SignUpValidator;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> findUser(String login, String password) throws RepositoryException {

        //TODO когда и где помещать в req все аттрибуты, которые нужны для страницы
        SQLSpecification specification = new SelectUserByLoginAndPasswordSpecification(login, password);
        List<User> users = UserRepository.getInstance().query(specification);
        if(users.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(users.get(0));
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

    public User findUserByLogin(String login) throws RepositoryException {
        return UserRepository.getInstance().query(new SelectUserByLoginSpecification(login)).get(0);
    }

}
