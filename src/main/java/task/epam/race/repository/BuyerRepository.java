package task.epam.race.repository;

import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Buyer;
import com.viazovski.flowerauction.model.Language;
import com.viazovski.flowerauction.model.Role;
import com.viazovski.flowerauction.specification.buyer.crud.AddBuyerSpecification;
import com.viazovski.flowerauction.specification.buyer.crud.RemoveBuyerSpecification;
import com.viazovski.flowerauction.specification.buyer.crud.SelectAllBuyersSpecification;
import com.viazovski.flowerauction.specification.buyer.crud.UpdateBuyerSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BuyerRepository extends AbstractRepository<Buyer> {

    @Override
    Buyer takeItem(ResultSet resultSet) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(resultSet.getInt(1));
        buyer.setFirstName(resultSet.getString(2));
        buyer.setLastName(resultSet.getString(3));
        buyer.setDateOfBirth(resultSet.getDate(4));
        buyer.setLogin(resultSet.getString(5));
        buyer.setPassword(resultSet.getString(6));
        buyer.setCreditCard(resultSet.getString(7));
        String langString = resultSet.getString(8);
        buyer.setLanguage(Language.valueOf(langString));
        String roleString = resultSet.getString(9);
        buyer.setRole(Role.valueOf(roleString));
        return buyer;
    }

    @Override
    public void add(Buyer buyer) throws RepositoryException {
        nonSelectQuery(new AddBuyerSpecification(buyer));
    }

    @Override
    public void remove(Buyer buyer) throws RepositoryException {
        nonSelectQuery(new RemoveBuyerSpecification(buyer));
    }

    @Override
    public void update(Buyer buyer) throws RepositoryException {
        nonSelectQuery(new UpdateBuyerSpecification(buyer));
    }

    @Override
    public List<Buyer> selectAll() throws RepositoryException {
        return selectQuery(new SelectAllBuyersSpecification());
    }
}
