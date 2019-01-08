package com.epam.race.service;

import com.epam.race.database.specification.userbet.SelectPreviousUserBetsSpecification;
import com.epam.race.database.specification.userbet.UpdateUserBetStateSpecification;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.user.UserBet;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.UserBetRepository;
import com.epam.race.database.specification.userbet.SelectCurrentUserBetsSpecification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class UserBetService {

    public List<UserBet> findCurrentUserBetsByLogin(String login) throws ServiceException {
        try {
            return UserBetRepository.getInstance().query(new SelectCurrentUserBetsSpecification(login));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
    public List<UserBet> findPreviousUserBetsByLogin(String login) throws ServiceException {
        try {
            return UserBetRepository.getInstance().query(new SelectPreviousUserBetsSpecification(login));
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

    public void addWinnings(Map<Integer, Horse> resultMap, int raceId) throws ServiceException {
        List<UserBet> userBets = findUserBetsByRaceId(raceId);
        UserService userService = new UserService();

        for(UserBet userBet: userBets){
            int expectedPosition = userBet.getPosition();
            Horse horse = resultMap.get(expectedPosition);
            if(horse.getHorseId() == userBet.getHorse().getHorseId()){
                BigDecimal amount = userService.findUserAmount(userBet.getUserLogin());
                BigDecimal prize = userBet.getSum().multiply(new BigDecimal(userBet.getCoeff()));
                userService.updateUserAmount(userBet.getUserLogin(),amount.add(prize));
                userBet.setSuccessful(true);
            }
            else {
                userBet.setSuccessful(false);
            }
        }
        updateUserBetsByRace(userBets);

    }

    public void updateUserBetsByRace(List<UserBet> userBets) throws ServiceException {
        try {
            for(UserBet userBet : userBets){
                UserBetRepository.getInstance().update(new UpdateUserBetStateSpecification(userBet));
            }
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}
