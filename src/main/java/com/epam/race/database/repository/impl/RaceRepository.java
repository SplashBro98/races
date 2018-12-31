package com.epam.race.database.repository.impl;

import com.epam.race.entity.common.Bet;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.database.pool.ConnectionPool;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.bet.SqlBetConstant;
import com.epam.race.database.specification.horse.SqlHorseConstant;
import com.epam.race.database.specification.race.SqlRaceConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.race.InsertRaceSpecification;
import com.epam.race.util.constant.DbCols;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Race findRaceWithBetsAndHorses(String raceName)  throws RepositoryException {

        try (Connection connection = ConnectionPool.getInstance().takeConnection()){
            PreparedStatement raceStatement = connection.prepareStatement(SqlRaceConstant.SQL_RACES_SELECT_BY_NAME);
            raceStatement.setString(1,raceName);
            ResultSet raceResultSet = raceStatement.executeQuery();
            if(!raceResultSet.next()) {
                throw new RepositoryException("resultSet was empty");
            }
            Race race = createItem(raceResultSet);

            PreparedStatement betStatement = connection.prepareStatement(SqlBetConstant.SQL_BETS_SELECT_BY_RACE_ID);
            betStatement.setInt(1,race.getRaceId());

            ResultSet betResultSet = betStatement.executeQuery();
            while (betResultSet.next()){
                Bet bet = new Bet();
                bet.setBetId(betResultSet.getInt(1));
                bet.setPosition(betResultSet.getInt(2));
                bet.setCoeff(betResultSet.getFloat(3));

                Horse horse = new Horse();
                horse.setName(betResultSet.getString(4));
                horse.setAge(betResultSet.getInt(5));
                horse.setWins(betResultSet.getInt(6));
                bet.setHorse(horse);

                race.addBet(bet);
                bet.setRace(race);
            }

            PreparedStatement horseStatement = connection.prepareStatement(SqlHorseConstant.SQL_HORSES_SELECT_BY_RACE_ID);
            horseStatement.setInt(1,race.getRaceId());

            ResultSet horseResultSet = horseStatement.executeQuery();
            while (horseResultSet.next()){
                Horse horse = HorseRepository.getInstance().createItem(horseResultSet);
                race.addHorse(horse);
            }

            return race;
        } catch (SQLException e) {
            logger.error("Problem with connection with database",e);
            throw new RepositoryException(e);
        }

    }



}
