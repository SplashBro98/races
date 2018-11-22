package task.epam.race.util.validation;

import task.epam.race.entity.User;
import task.epam.race.repository.UserRepository;
import task.epam.race.specification.user.SelectAllUsersSpecification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUpValidator {

    public boolean checkLogin(String login) throws SQLException {

        List<User> users = new UserRepository().query(new SelectAllUsersSpecification());
        List<String> loginList = new ArrayList<>();
        users.forEach(u -> loginList.add(u.getLogin()));
        boolean result = false;
        if(!loginList.contains(login)){
            result = true;
        }
        return result;
    }
}
