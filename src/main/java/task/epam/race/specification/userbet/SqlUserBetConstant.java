package task.epam.race.specification.userbet;

public final class SqlUserBetConstant {

    //language=sql
    public static final String SQL_USER_BETS_SELECT_ALL = "SELECT * from user_bets";

    //language=sql
    public static final String SQL_USER_BETS_INSERT = "insert into user_bets(user_login, betid, sum) VALUES" +
            "(?,?,?) ";


    //language=sql
    public static final String SQL_USER_BETS_SELECT_BY_LOGIN = "SELECT * from user_bets where " +
            "user_login = ?";

    //language=sql
    public static final String SQL_USER_BETS_REMOVE_BY_BET_ID= "delete from user_bets where " +
            "betid = ?";

}
