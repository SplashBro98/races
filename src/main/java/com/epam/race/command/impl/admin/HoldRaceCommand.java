package com.epam.race.command.impl.admin;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.entity.common.RaceResult;
import com.epam.race.service.*;
import com.epam.race.servlet.Router;
import com.epam.race.util.RandomGenerator;
import com.epam.race.command.StringAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class HoldRaceCommand implements Command {
    private static Logger logger = LogManager.getLogger(HoldRaceCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String raceName = req.getParameter(StringAttribute.RACE_NAME);
        List<Race> races= (List) req.getSession().getAttribute(StringAttribute.RACES);
        Race race = races.stream().filter(r -> r.getName().equals(raceName)).collect(Collectors.toList()).get(0);

        try{
            HorseService horseService = new HorseService();
            UserBetService userBetService = new UserBetService();
            RaceService raceService = new RaceService();
            RaceResultService raceResultService = new RaceResultService();
            RandomGenerator randomGenerator = new RandomGenerator();
            List<Horse> horses = horseService.findHorsesByRace(race.getRaceId());


            List<Integer> list = randomGenerator.randomNumbers();
            Map<Integer, Horse> raceResultMap = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                raceResultMap.put(i+1,horses.get(list.get(i)));
            }

            userBetService.addWinnings(raceResultMap,race.getRaceId());

            raceService.updateRaceState(race.getRaceId());
            horseService.addWin(raceResultMap.get(1).getHorseId());

            RaceResult raceResult = new RaceResult();
            raceResult.setRace(race);
            raceResult.setFirstHorseName(raceResultMap.get(1).getName());
            raceResult.setSecondHorseName(raceResultMap.get(2).getName());
            raceResult.setThirdHorseName(raceResultMap.get(3).getName());
            raceResult.setFourthHorseName(raceResultMap.get(4).getName());
            raceResultService.addResult(raceResult);

            horses.clear();
            raceResultMap.values().forEach(h -> horses.add(h));
            req.getSession().setAttribute(StringAttribute.HORSES,horses);
            req.getSession().setAttribute(StringAttribute.RACE_NAME,raceName);

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_RESULTS_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in HoldRaceCommand", e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
