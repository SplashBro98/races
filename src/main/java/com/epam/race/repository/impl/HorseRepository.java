package com.epam.race.repository.impl;

import com.epam.race.entity.Horse;
import com.epam.race.repository.AbstractRepository;
import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.horse.InsertHorseSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HorseRepository extends AbstractRepository<Horse> {
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
    public void remove(Horse horse) throws RepositoryException {

    }

    @Override
    public void update(Horse horse) throws RepositoryException {

    }

    @Override
    public List<Horse> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }

    @Override
    public Horse createItem(ResultSet resultSet) throws RepositoryException{
        Horse newHorse = new Horse();
        try {
            newHorse.setHorseId(resultSet.getInt("horse_id"));
            newHorse.setName(resultSet.getString("name"));
            newHorse.setAge(resultSet.getInt("age"));
            newHorse.setWins(resultSet.getInt("wins"));
            return newHorse;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }

    }
}
