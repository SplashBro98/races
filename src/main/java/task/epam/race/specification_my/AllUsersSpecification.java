package task.epam.race.specification_my;

import task.epam.race.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

import static task.epam.race.constant.SqlConstant.SQL_USERS_SELECT_ALL;

public class AllUsersSpecification extends Specification<User> {
    public AllUsersSpecification(Connection connection)throws SQLException {
        super(connection,SQL_USERS_SELECT_ALL);
    }
}
