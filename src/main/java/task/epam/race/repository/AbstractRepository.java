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



    public abstract T createItem(ResultSet resultSet);

    public void nonSelectQuery(SQLSpecification specification) {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<T> selectQuery(SQLSpecification specification) throws RepositoryException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()){
                result.add(createItem(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
}
