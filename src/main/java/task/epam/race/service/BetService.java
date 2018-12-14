package task.epam.race.service;

import task.epam.race.entity.Bet;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.BetRepository;
import task.epam.race.specification.bet.SelectBetsByRaceIdSpecification;

import java.util.List;

public class BetService {

//    public List<Bet> findUserBets(String login) throws RepositoryException {
//        return BetRepository.getInstance().query(new SelectUserBetsSpecification(login));
//    }

    public List<Bet> findRaceBets(int raceId) throws RepositoryException {
        return BetRepository.getInstance().query(new SelectBetsByRaceIdSpecification(raceId));
    }
}
