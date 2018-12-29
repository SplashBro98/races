package com.epam.race.repository.impl;

import com.epam.race.entity.Bet;
import com.epam.race.entity.Horse;
import com.epam.race.entity.Race;
import com.epam.race.repository.AbstractRepository;
import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.bet.InsertBetSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BetRepository extends AbstractRepository<Bet> {
    private static BetRepository instance;

    private BetRepository() {

    }

    public static BetRepository getInstance(){
        if(instance == null){
            instance = new BetRepository();
        }
        return instance;
    }


    @Override
    public Bet createItem(ResultSet resultSet) throws RepositoryException {
        Bet newBet = new Bet();
        try {
            newBet.setBetId(resultSet.getInt(1));
            Race race = new Race();
            race.setRaceId(resultSet.getInt(2));
            newBet.setRace(race);
            Horse horse = new Horse();
            horse.setHorseId(resultSet.getInt(3));
            newBet.setHorse(horse);
            newBet.setPosition(resultSet.getInt(4));
            newBet.setCoeff(resultSet.getFloat(5));
            return newBet;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void add(Bet bet) throws RepositoryException {
        nonSelectQuery(new InsertBetSpecification(bet));
    }

    @Override
    public void remove(Bet bet) throws RepositoryException {

    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {
        nonSelectQuery(specification);
    }

    @Override
    public List<Bet> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
