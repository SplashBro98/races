package com.epam.race.database.specification.horse;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetWinSpecification implements SQLSpecification {

    private int horseId;

    public SetWinSpecification(int horseId) {
        this.horseId = horseId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSES_UPDATE_WINS);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setInt(1,horseId);
            statement.setInt(2,horseId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }

    }
}
