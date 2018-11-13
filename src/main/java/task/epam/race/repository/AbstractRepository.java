package task.epam.race.repository;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.specification.SqlSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {

    private final String MESSAGE = "";

    @Override
    public List<T> query(SqlSpecification spec) throws RepositoryException {
        return selectQuery(spec);
    }

    abstract T takeItem(ResultSet resultSet) throws SQLException;

    void nonSelectQuery(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException(MESSAGE, e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    List<T> selectQuery(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(takeItem(resultSet));
            }
            return items;
        } catch (SQLException e) {
            throw new RepositoryException(MESSAGE, e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }
}
