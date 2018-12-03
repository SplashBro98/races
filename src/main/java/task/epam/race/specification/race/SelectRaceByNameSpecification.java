package task.epam.race.specification.race;

import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRaceByNameSpecification implements SQLSpecification {

    private String name;

    public SelectRaceByNameSpecification(String name) {
        this.name = name;
    }
    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlRaceConstant.SQL_RACES_SELECT_BY_NAME);
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
