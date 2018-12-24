package com.epam.race.specification.race;

import com.epam.race.exception.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRaceIdSpecification implements SQLSpecification {

    private String raceName;

    public SelectRaceIdSpecification(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlRaceConstant.SQL_RACES_SELECT_ID_BY_NAME);
            fillStatement(statement);
            return statement;

        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1, raceName);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
