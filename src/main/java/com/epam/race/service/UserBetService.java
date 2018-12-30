package com.epam.race.service;

import com.epam.race.entity.UserBet;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.UserBetRepository;
import com.epam.race.database.specification.userbet.SelectUserBetsSpecification;

import java.util.List;

public class UserBetService {

    public List<UserBet> findUserBetsByLogin(String login) throws ServiceException {
        try {
            return UserBetRepository.getInstance().query(new SelectUserBetsSpecification(login));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void addUserBet(UserBet userBet) throws ServiceException {
        try {
            UserBetRepository.getInstance().add(userBet);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public List<UserBet> findUserBetsByRaceId(int raceId) throws ServiceException {
        try{
            return UserBetRepository.getInstance().findUserBetsByRaceId(raceId);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}
