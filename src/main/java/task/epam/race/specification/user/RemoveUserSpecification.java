package task.epam.race.specification.user;

import task.epam.race.constant.SQLConstant;
import task.epam.race.entity.User;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveUserSpecification implements SQLSpecification {


    private User user;

    public RemoveUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_USERS_REMOVE_BY_ID);
        statement.setLong(1,user.getUserId());
        return statement;
    }
}
