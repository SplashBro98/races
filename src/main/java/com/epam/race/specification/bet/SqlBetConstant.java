package com.epam.race.specification.bet;

public final class SqlBetConstant {

    //language=sql
    public static final String SQL_BETS_SELECT_ALL = "SELECT * from bets";

    //language=sql
    public static final String SQL_BETS_INSERT = "insert into bets(describe, raceid, coeff) VALUES" +
            "(?,?,?) ";


    //language=sql
    public static final String SQL_BETS_SELECT_BY_RACE_ID = "SELECT * from bets where " +
            "raceid = ?";

    //language=sql
    public static final String SQL_BETS_REMOVE_BY_ID = "delete from bets where betid = ?";
}
