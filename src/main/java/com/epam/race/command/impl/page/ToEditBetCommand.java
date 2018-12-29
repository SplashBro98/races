package com.epam.race.command.impl.page;

import com.epam.race.command.Command;
import com.epam.race.command.PageManager;
import com.epam.race.entity.Bet;
import com.epam.race.util.constant.StringAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToEditBetCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {

        List<Bet> bets = (List) req.getSession().getAttribute(StringAttributes.BETS);
        int betId = Integer.parseInt(req.getParameter("betId"));
        Stream<Bet> betStream = bets.stream().filter(b -> b.getBetId() == betId);
        Bet bet = betStream.collect(Collectors.toList()).get(0);
        req.getSession().setAttribute(StringAttributes.BET, bet);
        return PageManager.INSTANCE.getProperty(PageManager.PATH_EDIT_BET_PAGE);
    }
}
