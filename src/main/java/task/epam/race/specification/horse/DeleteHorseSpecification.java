package task.epam.race.specification.horse;

import task.epam.race.util.constant.SQLConstant;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteHorseSpecification implements SQLSpecification {

    private String name;

    public DeleteHorseSpecification(String name) {
        this.name = name;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_HORSES_DELETE_BY_NAME);
        fillStatement(statement);
        return statement;
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1,name);
    }
}
