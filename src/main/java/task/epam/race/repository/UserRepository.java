package task.epam.race.repository;

import task.epam.race.entity.User;
import task.epam.race.entity.UserType;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.InsertUserSpecification;
import task.epam.race.specification.user.DeleteUserSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    @Override
    public User createItem(ResultSet resultSet) throws SQLException {
        User newUser = new User();
        newUser.setUserId(resultSet.getInt("userId"));
        newUser.setName(resultSet.getString("name"));
        newUser.setSurname(resultSet.getString("surname"));
        newUser.setLogin(resultSet.getString("login"));
        newUser.setLogin(resultSet.getString("password"));
        newUser.setEmail(resultSet.getString("email"));
        int type = resultSet.getInt("userType_id");
        switch (type){
            case 0:
                newUser.setUserType(UserType.ADMIN);
                break;
            case 1:
                newUser.setUserType(UserType.CLIENT);
                break;
            case 2:
                newUser.setUserType(UserType.BOOKMAKER);
                break;
        }
        return newUser;
    }

    @Override
    public void add(User user) throws SQLException {
        nonSelectQuery(new InsertUserSpecification(user));
    }

    @Override
    public void remove(User user) throws SQLException {
        nonSelectQuery(new DeleteUserSpecification(user));
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public List<User> query(SQLSpecification specification) throws SQLException {
        return selectQuery(specification);
    }



}
