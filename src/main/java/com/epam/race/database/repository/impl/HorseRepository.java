package com.epam.race.database.repository.impl;

import com.epam.race.database.ColumnName;
import com.epam.race.entity.common.Horse;
import com.epam.race.pool.ConnectionPool;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.horse.InsertHorseSpecification;
import com.epam.race.database.specification.horse.InsertHorseToHorseListSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HorseRepository extends AbstractRepository<Horse> {
    private static Logger logger = LogManager.getLogger(HorseRepository.class);
    private static HorseRepository instance;

    private HorseRepository(){

    }

    public static HorseRepository getInstance(){
        if(instance == null){
            instance = new HorseRepository();
        }
        return instance;
    }


    @Override
    public void add(Horse horse) throws RepositoryException {
        nonSelectQuery(new InsertHorseSpecification(horse));
    }

    @Override
    public void remove(Horse horse){
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {
        nonSelectQuery(specification);
    }

    @Override
    public List<Horse> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }

    @Override
    public Horse createItem(ResultSet resultSet) throws RepositoryException{
        Horse newHorse = new Horse();
        try {
            newHorse.setHorseId(resultSet.getInt(ColumnName.HORSE_ID));
            newHorse.setName(resultSet.getString(ColumnName.NAME));
            newHorse.setAge(resultSet.getInt(ColumnName.AGE));
            newHorse.setWins(resultSet.getInt(ColumnName.WINS));
            return newHorse;
        }catch (SQLException e){
            throw new RepositoryException("SQL Exception in createItem method",e);
        }
    }

    public void addHorseToHorseList(int raceId, int horseId) throws RepositoryException{
        nonSelectQuery(new InsertHorseToHorseListSpecification(horseId,raceId));
    }

    public int findHorseId(SQLSpecification specification) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;

        } catch (SQLException e) {
            logger.error("Problem with connection with database",e);
            throw new RepositoryException(e);
        }
    }

}
