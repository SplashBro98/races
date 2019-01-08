package com.epam.race.database.specification.userbet;

public final class SqlUserBetConstant {

    //language=sql
    static final String SQL_USER_BETS_SELECT_ALL = "SELECT * from user_bets";

    //language=sql
    static final String SQL_USER_BETS_INSERT = "insert into user_bets(user_login, bet_id, sum, coeff, " +
            "is_current, is_successful) VALUES" +
            "(?,?,?,?, true,null) ";


    //language=sql
    static final String SQL_USER_BETS_SELECT_BY_LOGIN = "SELECT u.user_login, u.bet_id," +
            "u.sum, h.name, b.position, u.coeff, r.name, r.place, r.time, r.date, u.is_successful " +
            "from user_bets u " +
            "join bets b on(u.bet_id = b.bet_id) " +
            "join races r on (b.race_id = r.race_id)" +
            "join horses h on(h.horse_id = b.horse_id)" +
            " where user_login = ?";
    //language=sql
    static final String SQL_USER_BETS_SELECT_CURRENT_BY_LOGIN = "SELECT u.user_login, u.bet_id," +
            "u.sum, h.name, b.position, u.coeff, r.name, r.place, r.time, r.date, u.is_successful " +
            "from user_bets u " +
            "join bets b on(u.bet_id = b.bet_id) " +
            "join races r on (b.race_id = r.race_id)" +
            "join horses h on(h.horse_id = b.horse_id)" +
            " where user_login = ? and u.is_current = true";
    //language=sql
    static final String SQL_USER_BETS_SELECT_NOT_CURRENT_BY_LOGIN = "SELECT u.user_login, u.bet_id," +
            "u.sum, h.name, b.position, u.coeff, r.name, r.place, r.time, r.date, u.is_successful " +
            "from user_bets u " +
            "join bets b on(u.bet_id = b.bet_id) " +
            "join races r on (b.race_id = r.race_id)" +
            "join horses h on(h.horse_id = b.horse_id)" +
            " where user_login = ? and u.is_current = false";
    //language=sql
    static final String SQL_USER_BETS_SELECT_BY_BET_ID = "SELECT * from user_bets where " +
            "bet_id = ?";
    //language=sql
    static final String SQL_USER_BETS_SELECT_BY_BET_ID_AND_LOGIN = "SELECT * from user_bets where " +
            "bet_id = ? and user_login = ?";

    //language=sql
    static final String SQL_USER_BETS_SELECT_BY_RACE_ID = "select u.user_login, u.sum, u.coeff, b.position, " +
            "b.horse_id, h.name, h.age, h.wins from user_bets u " +
            "join bets b on (u.bet_id = b.bet_id)" +
            "join horses h on (h.horse_id = b.horse_id) where b.race_id = ?";

    //language=sql
    static final String SQL_USER_BETS_REMOVE_BY_BET_ID = "delete from user_bets where " +
            "bet_id = ?";

    //language=sql
    static final String SQL_USER_BETS_REMOVE_BY_LOGIN = "delete from user_bets where " +
            "user_login = ?";

    //language=sql
    static final String SQL_USER_BETS_UPDATE_STATE = "update user_bets set is_current = false, " +
            "is_successful = ? where user_login = ? and bet_id = ?";


}
