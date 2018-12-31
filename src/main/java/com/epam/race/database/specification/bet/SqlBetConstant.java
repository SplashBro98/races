package com.epam.race.database.specification.bet;

public final class SqlBetConstant {

    //language=sql
     final String SQL_BETS_SELECT_ALL = "SELECT * from bets";

    //language=sql
    static final String SQL_BETS_INSERT = "insert into bets(race_id, horse_id, position, coeff) VALUES" +
            "(?,?,?,?) ";


    //language=sql
    public static final String SQL_BETS_SELECT_BY_RACE_ID = "SELECT b.bet_id, b.position, b.coeff, h.name, " +
            "h.age, h.wins " +
            "from bets b join horses h " +
            "on (h.horse_id = b.horse_id) where race_id = ?";

    //language=sql
    static final String SQL_BETS_REMOVE_BY_ID = "delete from bets where betid = ?";

    //language=sql
    static final String SQL_BETS_UPDATE_COEFF = "update bets set coeff = ? where bet_id = ?";
}
