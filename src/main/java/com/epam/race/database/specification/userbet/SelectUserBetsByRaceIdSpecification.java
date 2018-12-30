package com.epam.race.database.specification.userbet;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectUserBetsByRaceIdSpecification implements SQLSpecification {

    private int raceId;

    public SelectUserBetsByRaceIdSpecification(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserBetConstant.SQL_USER_BETS_SELECT_BY_RACE_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setInt(1,raceId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }

    }
}
