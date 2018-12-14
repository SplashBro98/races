package task.epam.race.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.entity.Race;
import task.epam.race.exception.RepositoryException;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.race.InsertRaceSpecification;
import task.epam.race.specification.race.SelectAllRacesSpecification;
import task.epam.race.util.constant.DbCols;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceRepository extends AbstractRepository<Race> {
    private static Logger logger = LogManager.getLogger(RaceRepository.class);
    private static RaceRepository instance;

    private RaceRepository() {

    }

    public static RaceRepository getInstance(){
        if(instance == null){
            instance = new RaceRepository();
        }
        return instance;
    }

    @Override
    public Race createItem(ResultSet resultSet) throws RepositoryException{
        try {
            Race newRace = new Race();
            newRace.setRaceId(resultSet.getInt(1));
            newRace.setName(resultSet.getString(DbCols.NAME));
            newRace.setPlace(resultSet.getString(DbCols.PLACE));
            newRace.setDate(resultSet.getDate(DbCols.DATE).toLocalDate());
            newRace.setTime(resultSet.getTime(DbCols.TIME).toLocalTime());
            return newRace;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void add(Race race) throws RepositoryException {
        nonSelectQuery(new InsertRaceSpecification(race));
    }

    @Override
    public void remove(Race race) throws RepositoryException {

    }

    @Override
    public void update(Race race) throws RepositoryException {

    }

    @Override
    public List<Race> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }

    public int findRaceId(SQLSpecification specification) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getInt(1);

        } catch (SQLException e) {
            logger.error("Problem with connection with database",e);
            throw new RepositoryException(e);
        }
    }



}
