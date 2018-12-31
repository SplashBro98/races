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
import com.epam.race.util.constant.StringAttributes;
import com.epam.race.util.validation.BetValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddBetCommand implements Command{
    private static Logger logger = LogManager.getLogger(AddBetCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        String page;

        String raceName = req.getParameter(StringAttributes.RACE_NAME);
        String horseName = req.getParameter(StringAttributes.HORSE_NAME);

        int position = Integer.parseInt(req.getParameter(StringAttributes.POSITION));


        String stringCoeff = req.getParameter(StringAttributes.COEFF);
        boolean isCorrectCoeff  = new BetValidator().isCorrectCoeff(stringCoeff);
        if(!isCorrectCoeff){
            req.setAttribute(StringAttributes.RACE_NAME, raceName);
            req.setAttribute(StringAttributes.HORSE_NAME, horseName);
            req.setAttribute(StringAttributes.POSITION, position);
            req.setAttribute("incorrect_coeff","incorrect coefficient");
            return PageManager.INSTANCE.getProperty(PageManager.PATH_ADD_BET_PAGE);
        }

        double coeff = Double.parseDouble(stringCoeff);
        try{

            Race race = new RaceService().findRace(raceName).get();
            Horse horse = new HorseService().findHorse(horseName).get();
            Bet bet = new Bet(race, horse, position, coeff);
            new BetService().addBet(bet);

            page = PageManager.INSTANCE.getProperty(PageManager.PATH_MAIN_PAGE);
        }catch (ServiceException e){
            logger.error("service or lower", e);
            page = PageManager.INSTANCE.getProperty(PageManager.PATH_ERROR_PAGE);
        }
        return page;
    }
}
