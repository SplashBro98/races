package com.epam.race.repository.impl;

import com.epam.race.entity.Bet;
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
            newBet.setDescribe(resultSet.getString(2));
            newBet.setBetId(resultSet.getInt(1));
            newBet.setCoeff(resultSet.getFloat(4));
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
    public void update(Bet bet) throws RepositoryException {

    }

    @Override
    public List<Bet> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
