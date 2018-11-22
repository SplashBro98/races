package task.epam.race.specification.user;

import task.epam.race.util.constant.SQLConstant;
import task.epam.race.entity.User;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserSpecification implements SQLSpecification {



    private User user;

    public InsertUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_USERS_INSERT);
        fillStatement(statement);
        return statement;
    }
    @Override
    public void fillStatement(PreparedStatement statement) throws SQLException{
        statement.setString(1,user.getName());
        statement.setString(2,user.getSurname());
        statement.setString(3,user.getLogin());
        statement.setString(4,user.getPassword());
        statement.setString(5,user.getEmail());
        statement.setInt(6,user.getUserType().ordinal());
    }
}
