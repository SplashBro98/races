package com.epam.race.repository.impl;

import com.epam.race.entity.Bet;
import com.epam.race.entity.Horse;
import com.epam.race.entity.Race;
import com.epam.race.pool.ConnectionPool;
import com.epam.race.repository.AbstractRepository;
import com.epam.race.repository.RepositoryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.race.InsertRaceSpecification;
import com.epam.race.util.constant.DbCols;

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
    public Race createItem(ResultSet resultSet) throws RepositoryException {
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
    public void update(SQLSpecification specification) throws RepositoryException {

    }

    @Override
    public List<Race> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }

    public int findRaceId(SQLSpecification specification) throws RepositoryException {
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

    public List<String> findRaceBetsAndHorses(SQLSpecification betSpecification, SQLSpecification horseSpecification,
                                      List<Bet> bets, List<Horse> horses)
            throws RepositoryException {

        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement betStatement = betSpecification.getStatement(connection::prepareStatement);
             PreparedStatement horseStatement = horseSpecification.getStatement(connection::prepareStatement)) {
            List<String> horseNames = new ArrayList<>();
            ResultSet betResultSet = betStatement.executeQuery();
            while (betResultSet.next()){
                Bet bet = new Bet();
                bet.setBetId(betResultSet.getInt(1));
                Race race = new Race();
                race.setRaceId(betResultSet.getInt(2));
                bet.setRace(race);
                bet.setPosition(betResultSet.getInt(3));
                bet.setCoeff(betResultSet.getFloat(4));
                horseNames.add(betResultSet.getString(5));
                bets.add(bet);
            }

            ResultSet horseResultSet = horseStatement.executeQuery();
            while (horseResultSet.next()){
                Horse horse = HorseRepository.getInstance().createItem(horseResultSet);
                horses.add(horse);
            }

            return horseNames;
        } catch (SQLException e) {
            logger.error("Problem with connection with database",e);
            throw new RepositoryException(e);
        }

    }



}
