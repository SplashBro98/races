package com.epam.race.service;

import com.epam.race.entity.common.Bet;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.BetRepository;
import com.epam.race.database.specification.bet.EditBetSpecification;

public class BetService {

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
