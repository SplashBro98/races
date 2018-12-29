package com.epam.race.specification.race;

import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.bet.SqlBetConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRaceBetsSpecification implements SQLSpecification {

    private int raceId;

    public SelectRaceBetsSpecification(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlBetConstant.SQL_BETS_SELECT_BY_RACE_ID);
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
