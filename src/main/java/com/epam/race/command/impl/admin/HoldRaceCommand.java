package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.entity.common.RaceResult;
import com.epam.race.entity.user.UserBet;
import com.epam.race.service.*;
import com.epam.race.util.RandomGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class HoldRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(HoldRaceCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String raceName = req.getParameter("raceName");
        List<Race> races= (List) req.getSession().getAttribute("races");
        Race race = races.stream().filter(r -> r.getName().equals(raceName)).collect(Collectors.toList()).get(0);

        try{
            HorseService horseService = new HorseService();
            UserBetService userBetService = new UserBetService();
            UserService userService = new UserService();
            RaceService raceService = new RaceService();
            RaceResultService raceResultService = new RaceResultService();
            RandomGenerator randomGenerator = new RandomGenerator();
            List<Horse> horses = horseService.findHorsesByRace(race.getRaceId());


            List<Integer> list = randomGenerator.randomNumbers();
            Map<Integer, Horse> raceResultMap = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                raceResultMap.put(i+1,horses.get(list.get(i)));
            }

            List<UserBet> userBets = userBetService.findUserBetsByRaceId(race.getRaceId());

            for(UserBet userBet: userBets){
                int expectedPosition = userBet.getPosition();
                Horse horse = raceResultMap.get(expectedPosition);
                if(horse.getHorseId() == userBet.getHorse().getHorseId()){
                    BigDecimal amount = userService.findUserAmount(userBet.getUserLogin());
                    BigDecimal prize = userBet.getSum().multiply(new BigDecimal(userBet.getCoeff()));
                    userService.updateUserAmount(userBet.getUserLogin(),amount.add(prize));
                }
            }

            raceService.updateRaceState(race.getRaceId());
            RaceResult raceResult = new RaceResult();
            raceResult.setRace(race);
            raceResult.setFirstHorseName(raceResultMap.get(1).getName());
            raceResult.setSecondHorseName(raceResultMap.get(2).getName());
            raceResult.setThirdHorseName(raceResultMap.get(3).getName());
            raceResult.setFourthHorseName(raceResultMap.get(4).getName());
            raceResultService.addResult(raceResult);

            horses.clear();
            raceResultMap.values().forEach(h -> horses.add(h));
            req.setAttribute("horses",horses);
            req.setAttribute("raceName",raceName);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_RESULTS_PAGE);
        }catch (ServiceException e){
            logger.error("HOLD ONN", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
