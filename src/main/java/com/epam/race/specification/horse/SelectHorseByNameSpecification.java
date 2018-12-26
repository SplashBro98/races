package com.epam.race.specification.horse;

import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectHorseByNameSpecification implements SQLSpecification {

    private String name;

    public SelectHorseByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSES_SELECT_BY_NAME);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1, name);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
