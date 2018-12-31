package com.epam.race.database.specification.raceresult;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.entity.common.RaceResult;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertResultSpecification implements SQLSpecification {
    private RaceResult raceResult;

    public InsertResultSpecification(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlRaceResultConstant.SQL_RACE_RESULTS_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setInt(1,raceResult.getRace().getRaceId());
            statement.setString(2,raceResult.getFirstHorseName());
            statement.setString(3,raceResult.getSecondHorseName());
            statement.setString(4,raceResult.getThirdHorseName());
            statement.setString(5,raceResult.getFourthHorseName());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
