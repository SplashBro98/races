package task.epam.race.repository.old;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.BuyerRequest;
import com.viazovski.flowerauction.specification.SqlSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerRequestRepository implements Repository<BuyerRequest> {

    private static Logger logger = LogManager.getLogger();

    @Language("SQL")
    private static final String ADD_SQL =
            "INSERT INTO `buyer_request` (`auction_id`, `buyer_id`) VALUES (?, ?)";

    @Language("SQL")
    private static final String REMOVE_SQL =
            "DELETE FROM `buyer_request`" +
                    " WHERE `auction_id` = ? AND `buyer_id` = ?";

    @Override
    public void add(BuyerRequest buyerRequest) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_SQL)) {
            statement.setInt(1, buyerRequest.getAuctionId());
            statement.setInt(2, buyerRequest.getBuyerId());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to add buyer request", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void remove(BuyerRequest buyerRequest) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_SQL)) {
            statement.setInt(1, buyerRequest.getAuctionId());
            statement.setInt(2, buyerRequest.getBuyerId());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove buyer request", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void removeIf(SqlSpecification spec) throws RepositoryException {
        throw new UnsupportedOperationException("Unable to remove from BuyerRequest table on condition");
    }

    @Override
    public void update(BuyerRequest item) throws RepositoryException {
        throw new UnsupportedOperationException("Unable to update BuyerRequest table");
    }

    @Override
    public void updateWhere(SqlSpecification spec) throws RepositoryException {
        throw new UnsupportedOperationException("Unable to update BuyerRequest table");
    }

    @Override
    public List<BuyerRequest> query(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<BuyerRequest> buyerRequests = new ArrayList<>();
            while (resultSet.next()) {
                buyerRequests.add(takeBuyerRequest(resultSet));
            }
            return buyerRequests;
        } catch (SQLException e) {
            throw new RepositoryException("Unable to query buyer requests on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    private BuyerRequest takeBuyerRequest(ResultSet resultSet) throws SQLException {
        BuyerRequest buyerRequest = new BuyerRequest();
        buyerRequest.setBuyerId(resultSet.getInt(1));
        buyerRequest.setAuctionId(resultSet.getInt(2));
        return buyerRequest;
    }
}
