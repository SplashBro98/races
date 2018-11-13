package task.epam.race.repository;

import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.BuyerAuction;
import com.viazovski.flowerauction.specification.buyerauction.crud.AddBuyerAuctionSpecification;
import com.viazovski.flowerauction.specification.buyerauction.crud.RemoveBuyerAuctionSpecification;
import com.viazovski.flowerauction.specification.buyerauction.crud.SelectAllBuyerAuctionsSpecification;
import com.viazovski.flowerauction.specification.buyerauction.crud.UpdateBuyerAuctionSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BuyerAuctionRepository extends AbstractRepository<BuyerAuction> {

    @Override
    BuyerAuction takeItem(ResultSet resultSet) throws SQLException {
        BuyerAuction buyerAuction = new BuyerAuction();
        buyerAuction.setBuyerId(resultSet.getInt(1));
        buyerAuction.setAuctionId(resultSet.getInt(2));
        buyerAuction.setBuyerAccepted(resultSet.getBoolean(3));
        return buyerAuction;
    }

    @Override
    public void add(BuyerAuction buyerAuction) throws RepositoryException {
        nonSelectQuery(new AddBuyerAuctionSpecification(buyerAuction));
    }

    @Override
    public void remove(BuyerAuction buyerAuction) throws RepositoryException {
        nonSelectQuery(new RemoveBuyerAuctionSpecification(buyerAuction));
    }

    @Override
    public void update(BuyerAuction buyerAuction) throws RepositoryException {
        nonSelectQuery(new UpdateBuyerAuctionSpecification(buyerAuction));
    }

    @Override
    public List<BuyerAuction> selectAll() throws RepositoryException {
        return selectQuery(new SelectAllBuyerAuctionsSpecification());
    }
}
