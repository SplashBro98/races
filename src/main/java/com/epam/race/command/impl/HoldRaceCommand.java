package com.epam.race.command.impl;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Horse;
import com.epam.race.entity.Race;
import com.epam.race.entity.UserBet;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.UserBetService;
import com.epam.race.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
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
            List<Horse> horses = horseService.findHorsesByRace(race.getRaceId());

            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            while (set.size() < 4){
                int a = (int) (Math.random() * 4);
                System.out.println(a);
                set.add(a);
            }
            List<Integer> list = set.stream().collect(Collectors.toList());
            Map<Integer, Horse> raceResult = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                raceResult.put(i+1,horses.get(list.get(i)));
            }

            List<UserBet> userBets = userBetService.findUserBetsByRaceId(race.getRaceId());

            for(UserBet userBet: userBets){
                int expectedPosition = userBet.getPosition();
                Horse horse = raceResult.get(expectedPosition);
                if(horse.getHorseId() == userBet.getHorse().getHorseId()){
                    BigDecimal amount = userService.findUserAmount(userBet.getUserLogin());
                    BigDecimal prize = userBet.getSum().multiply(new BigDecimal(userBet.getCoeff()));
                    userService.updateUserAmount(userBet.getUserLogin(),amount.add(prize));
                }
            }

            horses.clear();
            raceResult.values().forEach(h -> horses.add(h));
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
