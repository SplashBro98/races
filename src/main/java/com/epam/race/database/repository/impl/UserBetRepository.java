package com.epam.race.database.repository.impl;

import com.epam.race.database.specification.userbet.DeleteUserBetSpecification;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.pool.ConnectionPool;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.userbet.InsertUserBetSpecification;
import com.epam.race.entity.user.UserBet;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UserBetRepository extends AbstractRepository<UserBet> {
    private static UserBetRepository instance;

    //language=sql
    private static final String SQL_USER_BETS_SELECT_BY_RACE_ID = "select u.user_login, u.bet_id, u.sum, " +
            "u.coeff, b.position, " +
            "b.horse_id, h.name, h.age, h.wins from user_bets u " +
            "join bets b on (u.bet_id = b.bet_id)" +
            "join horses h on (h.horse_id = b.horse_id) where b.race_id = ?";

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
        UserBet newUserBet = new UserBet();
        try{
            newUserBet.setUserLogin(resultSet.getString(1));
            newUserBet.setSum(resultSet.getBigDecimal(3));
            newUserBet.setBetId(resultSet.getInt(2));
            Race race  = new Race();
            race.setName(resultSet.getString(7));
            race.setPlace(resultSet.getString(8));
            race.setTime(LocalTime.parse(resultSet.getString(9)));
            race.setDate(LocalDate.parse(resultSet.getString(10)));

            newUserBet.setRace(race);
            Horse horse = new Horse();
            horse.setName(resultSet.getString(4));
            newUserBet.setHorse(horse);
            newUserBet.setPosition(resultSet.getInt(5));
            newUserBet.setCoeff(resultSet.getDouble(6));
            newUserBet.setSuccessful(resultSet.getBoolean(11));


        }catch (SQLException e){
            throw new RepositoryException("SQL Exception in createItem method", e);
        }
        return newUserBet;
    }

    @Override
    public void add(UserBet userBet) throws RepositoryException {
        nonSelectQuery(new InsertUserBetSpecification(userBet));
    }

    @Override
    public void remove(UserBet userBet) throws RepositoryException {
        nonSelectQuery(new DeleteUserBetSpecification(userBet.getBetId()));
    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {
        nonSelectQuery(specification);
    }

    @Override
    public List<UserBet> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }


    public List<UserBet> findUserBetsByRaceId(int raceId) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection()) {
            PreparedStatement statement = connection.prepareStatement
                    (SQL_USER_BETS_SELECT_BY_RACE_ID);
            statement.setInt(1,raceId);
            List<UserBet> userBets = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                UserBet userBet = new UserBet();
                userBet.setUserLogin(resultSet.getString(1));
                userBet.setBetId(Integer.parseInt(resultSet.getString(2)));
                userBet.setSum(resultSet.getBigDecimal(3));
                userBet.setCoeff(resultSet.getDouble(4));
                userBet.setPosition(resultSet.getInt(5));
                Horse horse = new Horse();
                horse.setHorseId(resultSet.getInt(6));
                horse.setName(resultSet.getString(7));
                horse.setAge(resultSet.getInt(8));
                horse.setWins(resultSet.getInt(9));
                userBet.setHorse(horse);
                userBets.add(userBet);
            }
            return userBets;
        } catch (SQLException e) {
            throw new RepositoryException("SQL Exception in findUserBetsByRaceId method",e);
        }
    }
}
