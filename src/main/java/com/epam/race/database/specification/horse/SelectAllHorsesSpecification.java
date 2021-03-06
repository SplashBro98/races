package com.epam.race.database.specification.horse;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectAllHorsesSpecification implements SQLSpecification {

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            return function.apply(SqlHorseConstant.SQL_HORSES_SELECT_ALL);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {

    }
}
