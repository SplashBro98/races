package task.epam.race.repository;

import task.epam.race.entity.User;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.user.InsertUserSpecification;
import task.epam.race.specification.user.RemoveUserSpecification;
import task.epam.race.specification.user.SelectAllUsersSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    @Override
    public User createItem(ResultSet resultSet) {
        return null;
    }

    @Override
    public void add(User user) throws SQLException {
        nonSelectQuery(new InsertUserSpecification(user));
    }

    @Override
    public void remove(User user) throws SQLException {
        nonSelectQuery(new RemoveUserSpecification(user));
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public List<User> query(SQLSpecification specification) throws SQLException {
        return selectQuery(specification);
    }



}
