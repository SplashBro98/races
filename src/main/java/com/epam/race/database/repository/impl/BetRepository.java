package com.epam.race.database.repository.impl;

import com.epam.race.entity.common.Bet;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.bet.InsertBetSpecification;

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
            newBet.setCoeff(resultSet.getDouble(5));
            return newBet;
        }catch (SQLException e){
            throw new RepositoryException("SQLException in createItem method",e);
        }
    }

    @Override
    public void add(Bet bet) throws RepositoryException {
        nonSelectQuery(new InsertBetSpecification(bet));
    }

    @Override
    public void remove(Bet bet) {
        throw new UnsupportedOperationException();
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
