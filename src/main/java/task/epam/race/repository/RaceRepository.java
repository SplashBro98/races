package task.epam.race.repository;

import task.epam.race.entity.Race;
import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.race.InsertRaceSpecification;
import task.epam.race.specification.race.SelectAllRacesSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RaceRepository extends AbstractRepository<Race> {
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
            newRace.setName(resultSet.getString("name"));
            newRace.setPlace(resultSet.getString("place"));
            newRace.setDate(resultSet.getDate("date").toLocalDate());
            newRace.setTime(resultSet.getTime("time").toLocalTime());
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
}
