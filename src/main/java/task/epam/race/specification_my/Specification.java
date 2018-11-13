package task.epam.race.specification_my;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Specification<T> {

    private PreparedStatement preparedStatement;

    public Specification(Connection connection, String sqlQuery) throws SQLException {
        this.preparedStatement = connection.prepareStatement(sqlQuery) ;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }
}
