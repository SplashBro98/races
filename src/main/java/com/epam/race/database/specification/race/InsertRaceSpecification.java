package com.epam.race.database.specification.race;

import com.epam.race.entity.common.Race;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class InsertRaceSpecification implements SQLSpecification {

    private Race race;

    public InsertRaceSpecification(Race race) {
        this.race = race;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlRaceConstant.SQL_RACES_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1, race.getName());
            statement.setString(2, race.getPlace());
            statement.setDate(3, Date.valueOf(race.getDate()));
            statement.setTime(4, Time.valueOf(race.getTime()));
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
