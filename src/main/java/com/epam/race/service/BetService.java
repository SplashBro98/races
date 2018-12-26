package com.epam.race.service;

import com.epam.race.entity.Bet;
import com.epam.race.repository.RepositoryException;
import com.epam.race.repository.impl.BetRepository;
import com.epam.race.specification.bet.SelectBetsByRaceIdSpecification;

import java.util.List;

public class BetService {


    public List<Bet> findRaceBets(int raceId) throws ServiceException {
        try {
            return BetRepository.getInstance().query(new SelectBetsByRaceIdSpecification(raceId));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }


    public void addBet(Bet bet) throws ServiceException {
        try {
            BetRepository.getInstance().add(bet);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

}
