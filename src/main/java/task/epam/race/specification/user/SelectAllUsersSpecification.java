package task.epam.race.specification.user;

import task.epam.race.constant.SQLConstant;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllUsersSpecification implements SQLSpecification {



    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_USERS_SELECT_ALL);
        return statement;
    }
}
