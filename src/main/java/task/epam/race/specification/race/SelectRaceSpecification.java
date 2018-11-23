package task.epam.race.specification.race;

import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.util.constant.SQLConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRaceSpecification implements SQLSpecification {

    private String name;

    public SelectRaceSpecification(String name) {
        this.name = name;
    }
    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQLConstant.SQL_RACES_SELECT_BY_NAME);
        fillStatement(statement);
        return statement;
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1,name);
    }
}