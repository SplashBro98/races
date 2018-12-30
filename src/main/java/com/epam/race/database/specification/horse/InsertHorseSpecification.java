package com.epam.race.database.specification.horse;

import com.epam.race.entity.Horse;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHorseSpecification implements SQLSpecification {

    private Horse horse;

    public InsertHorseSpecification(Horse horse) {
        this.horse = horse;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSES_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1, horse.getName());
            statement.setInt(2, horse.getAge());
            statement.setInt(3, horse.getWins());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
