package task.epam.race.repository.old;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Flower;
import com.viazovski.flowerauction.model.Multiplying;
import com.viazovski.flowerauction.model.Soil;
import com.viazovski.flowerauction.specification.SqlSpecification;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlowerRepository implements Repository<Flower> {

    @Language("SQL")
    private static final String ADD_SQL =
            "INSERT INTO flower " +
            "(name, value, `condition`, origin, soil, flower_color, flower_size, multiplying) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    @Language("SQL")
    private static final String REMOVE_SQL =
            "DELETE FROM flower WHERE flower_id = ?";

    @Language("SQL")
    private static final String UPDATE_SQL =
            "UPDATE flower " +
            "SET name = ?, value = ?, `condition` = ?, origin = ?, " +
                "soil = ?, flower_color = ?, flower_size = ?, multiplying = ? " +
            "WHERE flower_id = ?";

    @Override
    public void add(Flower flower) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_SQL)) {
            prepareAddValues(flower, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to add flower", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void remove(Flower flower) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_SQL)) {
            statement.setInt(1, flower.getFlowerId());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove flower", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void removeIf(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove flowers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void update(Flower flower) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            prepareUpdateValues(flower, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to update flowers", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void updateWhere(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove flowers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public List<Flower> query(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<Flower> flowers = new ArrayList<>();
            while (resultSet.next()) {
                flowers.add(takeFlower(resultSet));
            }
            return flowers;
        } catch (SQLException e) {
            throw new RepositoryException("Unable to query flowers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    private void prepareAddValues(Flower flower, PreparedStatement statement) throws SQLException {
        statement.setString(1, flower.getName());
        statement.setInt(2, flower.getValue());
        statement.setString(3, flower.getCondition());
        statement.setString(4, flower.getOrigin());
        statement.setString(5, flower.getSoil().toString());
        statement.setString(6, flower.getColor());
        statement.setInt(7, flower.getSize());
        statement.setString(8, flower.getMultiplying().toString());
    }

    private void prepareUpdateValues(Flower flower, PreparedStatement statement) throws SQLException {
        prepareAddValues(flower, statement);
        statement.setInt(9, flower.getFlowerId());
    }

    private Flower takeFlower(ResultSet resultSet) throws SQLException {
        Flower flower = new Flower();
        flower.setFlowerId(resultSet.getInt(1));
        flower.setName(resultSet.getString(2));
        flower.setValue(resultSet.getInt(3));
        flower.setCondition(resultSet.getString(4));
        flower.setOrigin(resultSet.getString(5));
        String soilString = resultSet.getString(6).trim().toUpperCase();
        flower.setSoil(Soil.valueOf(soilString));
        flower.setColor(resultSet.getString(7));
        flower.setSize(resultSet.getInt(8));
        String multiplyingString = resultSet.getString(7).trim().toUpperCase();
        flower.setMultiplying(Multiplying.valueOf(multiplyingString));
        return flower;
    }
}
