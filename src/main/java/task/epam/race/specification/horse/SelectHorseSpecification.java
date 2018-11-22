package task.epam.race.specification.horse;

import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectHorseSpecification implements SQLSpecification {

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        return null;
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws SQLException {

    }
}
