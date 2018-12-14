package task.epam.race.repository;

import task.epam.race.entity.UserBet;
import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLSpecification;

import java.sql.ResultSet;
import java.util.List;

public class UserBetRepository extends AbstractRepository<UserBet> {
    private static UserBetRepository instance;

    private UserBetRepository() {

    }

    public static UserBetRepository getInstance(){
        if(instance == null){
            instance = new UserBetRepository();
        }
        return instance;
    }

    @Override
    public UserBet createItem(ResultSet resultSet) throws RepositoryException {
        return null;
    }

    @Override
    public void add(UserBet userBet) throws RepositoryException {

    }

    @Override
    public void remove(UserBet userBet) throws RepositoryException {

    }

    @Override
    public void update(UserBet userBet) throws RepositoryException {

    }

    @Override
    public List<UserBet> query(SQLSpecification specification) throws RepositoryException {
        return null;
    }
}
