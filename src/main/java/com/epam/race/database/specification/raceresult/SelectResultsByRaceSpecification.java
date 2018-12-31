package com.epam.race.database.specification.raceresult;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectResultsByRaceSpecification implements SQLSpecification {

    private int raceId;

    public SelectResultsByRaceSpecification(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlRaceResultConstant.SQL_RACE_RESULTS_SELECT_BY_RACE);
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
