package com.epam.race.service;

import com.epam.race.entity.common.Bet;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.BetRepository;
import com.epam.race.database.specification.bet.EditBetSpecification;
import com.epam.race.database.specification.bet.SelectBetsByRaceIdSpecification;

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

    public void updateBetCoeff(int betId, double coeff) throws ServiceException {
        try{
            BetRepository.getInstance().update(new EditBetSpecification(betId, coeff));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

}
