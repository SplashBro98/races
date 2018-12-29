package com.epam.race.specification.userbet;

public final class SqlUserBetConstant {

    //language=sql
    public static final String SQL_USER_BETS_SELECT_ALL = "SELECT * from user_bets";

    //language=sql
    public static final String SQL_USER_BETS_INSERT = "insert into user_bets(user_login, betid, sum, coeff) VALUES" +
            "(?,?,?,?) ";


    //language=sql
    public static final String SQL_USER_BETS_SELECT_BY_LOGIN = "SELECT u.user_login, u.betid," +
            "u.sum, h.name, b.position, u.coeff, r.name, r.place, r.time, r.date " +
            "from user_bets u " +
            "join bets b on(u.betid = b.bet_id) " +
            "join races r on (b.race_id = r.race_id)" +
            "join horses h on(h.horse_id = b.horse_id)" +
            " where user_login = ?";
    //language=sql
    public static final String SQL_USER_BETS_SELECT_BY_BET_ID = "SELECT * from user_bets where " +
            "betid = ?";
    //language=sql
    public static final String SQL_USER_BETS_SELECT_BY_BET_ID_AND_LOGIN = "SELECT * from user_bets where " +
            "betid = ? and user_login = ?";

    //language=sql
    public static final String SQL_USER_BETS_REMOVE_BY_BET_ID = "delete from user_bets where " +
            "betid = ?";

    //language=sql
    public static final String SQL_USER_BETS_REMOVE_BY_LOGIN = "delete from user_bets where " +
            "user_login = ?";

}
