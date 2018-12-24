package com.epam.race.specification.user;

import com.epam.race.exception.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectUserByLoginSpecification implements SQLSpecification {

    private String login;

    public SelectUserByLoginSpecification(String login) {
        this.login = login;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserConstant.SQL_USERS_SELECT_BY_LOGIN);
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
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
