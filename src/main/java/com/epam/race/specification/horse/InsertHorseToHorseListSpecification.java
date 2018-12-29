package com.epam.race.specification.horse;

import com.epam.race.repository.Repository;
import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHorseToHorseListSpecification implements SQLSpecification {

    private int horseId;
    private int raceId;

    public InsertHorseToHorseListSpecification(int horseId, int raceId) {
        this.horseId = horseId;
        this.raceId = raceId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSE_LIST_INSERT);
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
            statement.setInt(2,horseId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
