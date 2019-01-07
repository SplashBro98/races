package com.epam.race.database.repository.impl;

import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.raceresult.InsertResultSpecification;
import com.epam.race.entity.common.Race;
import com.epam.race.entity.common.RaceResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RaceResultRepository extends AbstractRepository<RaceResult> {

    private static RaceResultRepository instance;

    private RaceResultRepository() {

    }

    public static RaceResultRepository getInstance() {
        if (instance == null) {
            instance = new RaceResultRepository();
        }
        return instance;
    }

    @Override
    public RaceResult createItem(ResultSet resultSet) throws RepositoryException {
        try {
            RaceResult raceResult = new RaceResult();
            Race race = new Race();
            race.setName(resultSet.getString(1));
            race.setPlace(resultSet.getString(2));
            raceResult.setRace(race);

            raceResult.setFirstHorseName(resultSet.getString(3));
            raceResult.setSecondHorseName(resultSet.getString(4));
            raceResult.setThirdHorseName(resultSet.getString(5));
            raceResult.setFourthHorseName(resultSet.getString(6));

            return raceResult;
        } catch (SQLException e) {
            throw new RepositoryException("SQL Exception in createItem method", e);
        }
    }

    @Override
    public void add(RaceResult raceResult) throws RepositoryException {
        nonSelectQuery(new InsertResultSpecification(raceResult));
    }

    @Override
    public void remove(RaceResult raceResult) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(SQLSpecification specification) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<RaceResult> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
