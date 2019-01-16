package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.common.Bet;
import com.epam.race.command.StringAttribute;
import com.epam.race.servlet.Router;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToEditBetCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        List<Bet> bets = (List) req.getSession().getAttribute(StringAttribute.BETS);
        int betId = Integer.parseInt(req.getParameter(StringAttribute.BET_ID));
        Stream<Bet> betStream = bets.stream().filter(b -> b.getBetId() == betId);
        Bet bet = betStream.collect(Collectors.toList()).get(0);
        req.setAttribute(StringAttribute.BET, bet);

        router.setPage(PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_BET_PAGE));
        return router;
    }
}
