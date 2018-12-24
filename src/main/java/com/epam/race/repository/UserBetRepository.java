package com.epam.race.repository;

import com.epam.race.entity.Race;
import com.epam.race.exception.RepositoryException;
import com.epam.race.specification.userbet.InsertUserBetSpecification;
import com.epam.race.entity.UserBet;
import com.epam.race.specification.SQLSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
        UserBet newUserBet = new UserBet();
        try{
            newUserBet.setUserLogin(resultSet.getString(1));
            newUserBet.setSum(resultSet.getBigDecimal(3));
            newUserBet.setBetId(resultSet.getInt(2));
            newUserBet.setDescribe(resultSet.getString(4));
            newUserBet.setCoeff(resultSet.getDouble(5));
//            Race race = new Race();
//            race.setName(resultSet.getString(6));
//            race.setPlace(resultSet.getString(7));
//            race.setTime(LocalTime.parse(resultSet.getString(8)));
//            race.setDate(LocalDate.parse(resultSet.getString(9)));
//            newUserBet.setRace(race);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
        return newUserBet;
    }

    @Override
    public void add(UserBet userBet) throws RepositoryException {
        nonSelectQuery(new InsertUserBetSpecification(userBet));
    }

    @Override
    public void remove(UserBet userBet) throws RepositoryException {

    }

    @Override
    public void update(UserBet userBet) throws RepositoryException {

    }

    @Override
    public List<UserBet> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
