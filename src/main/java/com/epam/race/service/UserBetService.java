package com.epam.race.service;

import com.epam.race.entity.UserBet;
import com.epam.race.repository.RepositoryException;
import com.epam.race.repository.impl.UserBetRepository;
import com.epam.race.specification.userbet.SelectUserBetsSpecification;

import java.util.List;

public class UserBetService {

    public List<UserBet> findUserBets(String login) throws ServiceException {
        try {
            return UserBetRepository.getInstance().query(new SelectUserBetsSpecification(login));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public boolean addUserBet(UserBet userBet){
        return false;
    }
}
