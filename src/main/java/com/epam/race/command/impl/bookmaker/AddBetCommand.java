package com.epam.race.command.impl.bookmaker;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Bet;
import com.epam.race.entity.common.Horse;
import com.epam.race.entity.common.Race;
import com.epam.race.service.HorseService;
import com.epam.race.service.ServiceException;
import com.epam.race.service.BetService;
import com.epam.race.service.RaceService;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;
import com.epam.race.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddBetCommand implements Command{
    private static Logger logger = LogManager.getLogger(AddBetCommand.class);

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();

        String raceName = req.getParameter(StringAttribute.RACE_NAME);
        String horseName = req.getParameter(StringAttribute.HORSE_NAME);

        int position = Integer.parseInt(req.getParameter(StringAttribute.POSITION));

        String stringCoeff = req.getParameter(StringAttribute.COEFF);
        boolean isCorrectCoeff  = new BetValidator().isCorrectCoeff(stringCoeff);
        if(!isCorrectCoeff){
            req.setAttribute(StringAttribute.RACE_NAME, raceName);
            req.setAttribute(StringAttribute.HORSE_NAME, horseName);
            req.setAttribute(StringAttribute.POSITION, position);
            req.setAttribute(StringAttribute.INCORRECT_COEFF, StringAttribute.TRUE);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE));
            return router;
        }

        double coeff = Double.parseDouble(stringCoeff);
        try{

            Race race = new RaceService().findRace(raceName).get();
            Horse horse = new HorseService().findHorse(horseName).get();
            Bet bet = new Bet(race, horse, position, coeff);
            BetService betService = new BetService();
            betService.addBet(bet);

            router.setRedirect();
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE));
        }catch (ServiceException e){
            logger.error("Service Exception in AddBetCommand", e);
            req.setAttribute(StringAttribute.E,e);
            router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE));
        }
        return router;
    }
}
