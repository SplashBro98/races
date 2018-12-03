package task.epam.race.specification;

import task.epam.race.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Function;

public interface SQLSpecification {

    PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException;
    void fillStatement(PreparedStatement statement) throws RepositoryException;
}

