package com.epam.race.database.specification.user;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnlockUserSpecification implements SQLSpecification {

    private String login;

    public UnlockUserSpecification(String login) {
        this.login = login;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserConstant.SQL_USERS_UNLOCK_USER);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setString(1,login);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
