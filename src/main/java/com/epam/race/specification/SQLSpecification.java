package com.epam.race.specification;

import com.epam.race.repository.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLSpecification {

    PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException;
    void fillStatement(PreparedStatement statement) throws RepositoryException;
}

