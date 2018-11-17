package task.epam.race.specification.user;

import task.epam.race.constant.SQLConstant;
import task.epam.race.entity.User;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectUserSpecification implements SQLSpecification {

    private String login;
    private String password;

    public SelectUserSpecification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_USERS_SELECT_BY_LOGIN_AND_PASSWORD);
        statement.setString(1,login);
        statement.setString(2,password);
        return statement;
    }
}
