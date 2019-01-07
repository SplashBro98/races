package com.epam.race.database.specification.userbet;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectPreviousUserBetsSpecification implements SQLSpecification {

    private String login;

    public SelectPreviousUserBetsSpecification(String login) {
        this.login = login;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserBetConstant.SQL_USER_BETS_SELECT_NOT_CURRENT_BY_LOGIN);
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
