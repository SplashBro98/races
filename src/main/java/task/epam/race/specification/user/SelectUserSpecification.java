package task.epam.race.specification.user;

import task.epam.race.exception.RepositoryException;
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
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlUserConstant.
                    SQL_USERS_SELECT_BY_LOGIN_AND_PASSWORD);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1, login);
            statement.setString(2, password);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
