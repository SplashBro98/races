package task.epam.race.repository.old;

import com.viazovski.flowerauction.connection.ConnectionPool;
import com.viazovski.flowerauction.exception.ConnectionException;
import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Buyer;
//import com.viazovski.flowerauction.model.Language;
import com.viazovski.flowerauction.model.Role;
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

public class BuyerRepository implements Repository<Buyer> {

    private static Logger logger = LogManager.getLogger();

    @Language("SQL")
    private static final String ADD_SQL =
            "INSERT INTO buyer " +
            "(first_name, last_name, dob, login, password, credit_card) " +
            "VALUES(?, ?, ?, ?, ?, ?)";

    @Language("SQL")
    private static final String REMOVE_SQL =
            "DELETE FROM buyer WHERE buyer_id = ?";

    @Language("SQL")
    private static final String UPDATE_SQL =
            "UPDATE buyer " +
                    "SET first_name = ?, last_name = ?, dob = ?, login = ?, " +
                    "password = ?, credit_card = ? " +
                    "WHERE buyer_id = ?";

    @Override
    public void add(Buyer buyer) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_SQL)) {
            prepareAddValues(buyer, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to add buyer", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void remove(Buyer buyer) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_SQL)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to remove buyer", e);
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
            throw new RepositoryException("Unable to remove buyers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public void update(Buyer buyer) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            prepareUpdateValues(buyer, statement);
            statement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Unable to update buyer", e);
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
            throw new RepositoryException("Unable to update buyers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    @Override
    public List<Buyer> query(SqlSpecification spec) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = spec.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<Buyer> buyers = new ArrayList<>();
            while (resultSet.next()) {
                buyers.add(takeBuyer(resultSet));
            }
            return buyers;
        } catch (SQLException e) {
            throw new RepositoryException("Unable to query buyers on condition", e);
        } catch (ConnectionException e) {
            throw new RepositoryException("Unable to create connection", e);
        }
    }

    private void prepareAddValues(Buyer buyer, PreparedStatement statement) throws SQLException {
        statement.setString(1, buyer.getFirstName());
        statement.setString(2, buyer.getLastName());
        statement.setDate(3, buyer.getDateOfBirth());
        statement.setString(4, buyer.getLogin());
        statement.setString(5, buyer.getPassword());
        statement.setString(6, buyer.getCreditCard());
    }

    private void prepareUpdateValues(Buyer buyer, PreparedStatement statement) throws SQLException {
        prepareAddValues(buyer, statement);
        statement.setInt(7, buyer.getBuyerId());
    }

    private Buyer takeBuyer(ResultSet resultSet) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(resultSet.getInt(1));
        buyer.setFirstName(resultSet.getString(2));
        buyer.setLastName(resultSet.getString(3));
        buyer.setDateOfBirth(resultSet.getDate(4));
        buyer.setLogin(resultSet.getString(5));
        buyer.setPassword(resultSet.getString(6));
        buyer.setCreditCard(resultSet.getString(7));
//        String langString = resultSet.getString(8);
//        buyer.setLanguage(Language.valueOf(langString));
        String roleString = resultSet.getString(9);
        buyer.setRole(Role.valueOf(roleString));
        return buyer;
    }
}
