package task.epam.race.specification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLSpecification {

    PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException;
    void fillStatement(PreparedStatement statement) throws SQLException;
}
