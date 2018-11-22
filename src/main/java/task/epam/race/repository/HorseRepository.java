package task.epam.race.repository;

import task.epam.race.entity.Horse;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.horse.DeleteHorseSpecification;
import task.epam.race.specification.horse.InsertHorseSpecification;
import task.epam.race.specification.horse.SelectAllHorsesSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HorseRepository extends AbstractRepository<Horse> {

    @Override
    public void add(Horse horse) throws SQLException {
        nonSelectQuery(new InsertHorseSpecification(horse));
    }

    @Override
    public void remove(Horse horse) throws SQLException {
        nonSelectQuery(new DeleteHorseSpecification(horse.getName()));
    }

    @Override
    public void update(Horse horse) throws SQLException {

    }

    @Override
    public List<Horse> query(SQLSpecification specification) throws SQLException {
        return selectQuery(new SelectAllHorsesSpecification());
    }

    @Override
    public Horse createItem(ResultSet resultSet) throws SQLException{
        Horse newHorse = new Horse();
        newHorse.setHorseId(resultSet.getInt("horse_id"));
        newHorse.setName(resultSet.getString("name"));
        newHorse.setAge(resultSet.getInt("age"));
        newHorse.setWins(resultSet.getInt("wins"));
        return newHorse;
    }
}
