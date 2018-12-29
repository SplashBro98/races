package com.epam.race.specification.bet;

public final class SqlBetConstant {

    //language=sql
    public static final String SQL_BETS_SELECT_ALL = "SELECT * from bets";

    //language=sql
    public static final String SQL_BETS_INSERT = "insert into bets(race_id, horse_id, position, coeff) VALUES" +
            "(?,?,?,?) ";


    //language=sql
    public static final String SQL_BETS_SELECT_BY_RACE_ID = "SELECT b.bet_id, b.race_id, b.position, b.coeff, h.name " +
            "from bets b join horses h " +
            "on (h.horse_id = b.horse_id) where race_id = ?";

    //language=sql
    public static final String SQL_BETS_REMOVE_BY_ID = "delete from bets where betid = ?";
}
