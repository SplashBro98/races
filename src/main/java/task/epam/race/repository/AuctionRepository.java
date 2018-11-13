package task.epam.race.repository;

import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Auction;
import com.viazovski.flowerauction.specification.auction.crud.AddAuctionSpecification;
import com.viazovski.flowerauction.specification.auction.crud.RemoveAuctionSpecification;
import com.viazovski.flowerauction.specification.auction.crud.SelectAllAuctionsSpecification;
import com.viazovski.flowerauction.specification.auction.crud.UpdateAuctionSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuctionRepository extends AbstractRepository<Auction> {
    
    @Override
    Auction takeItem(ResultSet resultSet) throws SQLException {
        Auction auction = new Auction();
        auction.setAuctionId(resultSet.getInt(1));
        auction.setName(resultSet.getString(2));
        auction.setEventDate(resultSet.getTimestamp(3));
        return auction;
    }

    @Override
    public void add(Auction auction) throws RepositoryException {
        nonSelectQuery(new AddAuctionSpecification(auction));
    }

    @Override
    public void remove(Auction auction) throws RepositoryException {
        nonSelectQuery(new RemoveAuctionSpecification(auction));
    }

    @Override
    public void update(Auction auction) throws RepositoryException {
        nonSelectQuery(new UpdateAuctionSpecification(auction));
    }

    @Override
    public List<Auction> selectAll() throws RepositoryException {
        return selectQuery(new SelectAllAuctionsSpecification());
    }
}
