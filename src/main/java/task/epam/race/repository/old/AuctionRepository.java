package task.epam.race.repository.old;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Auction;
import com.viazovski.flowerauction.specification.SqlSpecification;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionRepository implements Repository<Auction> {

    @Language("SQL")
    private static final String ADD_SQL = "INSERT INTO auction (name, event_date) VALUES (?, ?)";

    @Language("SQL")
    private static final String REMOVE_SQL = "DELETE FROM auction WHERE auction_id = ?";

    @Language("SQL")
    private static final String UPDATE_SQL = "UPDATE auction SET name = ?, event_date = ? WHERE auction_id = ?";

    @Override
    public void add(Auction auction) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_SQL)) {
            prepareAddValues(auction, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to add auction", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void remove(Auction auction) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_SQL)) {
            statement.setInt(1, auction.getAuctionId());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove auction", e);
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
            throw new RepositoryException("Unable to remove auctions on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void update(Auction auction) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            prepareUpdateValues(auction, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to update auction", e);
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
            throw new RepositoryException("Unable to update auctions on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public List<Auction> query(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<Auction> auctions = new ArrayList<>();
            while (resultSet.next()) {
                auctions.add(takeAuction(resultSet));
            }
            return auctions;
        } catch (SQLException e) {
            throw new RepositoryException("Unable to query buyers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    private void prepareAddValues(Auction auction, PreparedStatement statement) throws SQLException {
        statement.setString(1, auction.getName());
        statement.setTimestamp(2, auction.getEventDate());
    }

    private void prepareUpdateValues(Auction auction, PreparedStatement statement) throws SQLException {
        prepareAddValues(auction, statement);
        statement.setInt(3, auction.getAuctionId());
    }

    private Auction takeAuction(ResultSet resultSet) throws SQLException {
        Auction auction = new Auction();
        auction.setAuctionId(resultSet.getInt(1));
        auction.setName(resultSet.getString(2));
        auction.setEventDate(resultSet.getTimestamp(3));
        return auction;
    }
}
