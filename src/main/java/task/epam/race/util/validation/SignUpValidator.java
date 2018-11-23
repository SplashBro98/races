package task.epam.race.util.validation;

import task.epam.race.entity.User;
import task.epam.race.repository.UserRepository;
import task.epam.race.specification.user.SelectAllUsersSpecification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUpValidator {

    public boolean checkLogin(String login) throws SQLException {

        List<User> users = UserRepository.getInstance().query(new SelectAllUsersSpecification());
        List<String> loginList = new ArrayList<>();
        users.forEach(u -> loginList.add(u.getLogin()));
        return !loginList.contains(login);
    }
}
