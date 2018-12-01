package task.epam.race.specification.user;

import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Function;

public class SelectUserSpecification implements SQLSpecification {

    private String login;
    private String password;

    public SelectUserSpecification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLUserConstant.SQL_USERS_SELECT_BY_LOGIN_AND_PASSWORD);
        fillStatement(statement);
        return statement;
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1,login);
        statement.setString(2,password);
    }
}
