package task.epam.race.repository;

import task.epam.race.exception.RepositoryException;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {



    public abstract T createItem(ResultSet resultSet) throws SQLException;

    protected void nonSelectQuery(SQLSpecification specification) {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            statement.execute();
            ConnectionPool.getInstance().returnConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected List<T> selectQuery(SQLSpecification specification) throws RepositoryException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()){
                result.add(createItem(resultSet));
            }
            ConnectionPool.getInstance().returnConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
