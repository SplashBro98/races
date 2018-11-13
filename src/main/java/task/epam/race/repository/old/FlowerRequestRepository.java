package task.epam.race.repository.old;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.FlowerRequest;
import com.viazovski.flowerauction.specification.SqlSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlowerRequestRepository implements Repository<FlowerRequest> {

    @Override
    public void add(FlowerRequest item) throws RepositoryException {

    }

    @Override
    public void remove(FlowerRequest item) throws RepositoryException {

    }

    @Override
    public void removeIf(SqlSpecification spec) throws RepositoryException {

    }

    @Override
    public void update(FlowerRequest item) throws RepositoryException {

    }

    @Override
    public void updateWhere(SqlSpecification spec) throws RepositoryException {

    }

    @Override
    public List<FlowerRequest> query(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<FlowerRequest> flowerRequests = new ArrayList<>();
            while (resultSet.next()) {
                flowerRequests.add(takeFlowerRequest(resultSet));
            }
            return flowerRequests;
        } catch (SQLException e) {
            throw new RepositoryException("Unable to query flower requests on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    private FlowerRequest takeFlowerRequest(ResultSet resultSet) throws SQLException {
        FlowerRequest flowerRequest = new FlowerRequest();
        flowerRequest.setFlowerId(resultSet.getInt(1));
        flowerRequest.setAuctionId(resultSet.getInt(2));
        return flowerRequest;
    }
}
