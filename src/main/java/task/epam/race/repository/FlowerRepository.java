package task.epam.race.repository;

import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.model.Flower;
import com.viazovski.flowerauction.specification.flower.crud.AddFlowerSpecification;
import com.viazovski.flowerauction.specification.flower.crud.RemoveFlowerSpecification;
import com.viazovski.flowerauction.specification.flower.crud.SelectAllFlowersSpecification;
import com.viazovski.flowerauction.specification.flower.crud.UpdateFlowerSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlowerRepository extends AbstractRepository<Flower> {
    
    @Override
    Flower takeItem(ResultSet resultSet) throws SQLException {
        Flower flower = new Flower();
        flower.setFlowerId(resultSet.getInt(1));
        flower.setName(resultSet.getString(2));
        flower.setValue(resultSet.getInt(3));
        flower.setFlowerAccepted(resultSet.getBoolean(4));
        return flower;
    }

    @Override
    public void add(Flower flower) throws RepositoryException {
        nonSelectQuery(new AddFlowerSpecification(flower));
    }

    @Override
    public void remove(Flower flower) throws RepositoryException {
        nonSelectQuery(new RemoveFlowerSpecification(flower));
    }

    @Override
    public void update(Flower flower) throws RepositoryException {
        nonSelectQuery(new UpdateFlowerSpecification(flower));
    }

    @Override
    public List<Flower> selectAll() throws RepositoryException {
        return selectQuery(new SelectAllFlowersSpecification());
    }
}
