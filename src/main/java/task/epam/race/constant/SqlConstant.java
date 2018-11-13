package task.epam.race.constant;

public final class SqlConstant {
    //language=sql
    public static final String SQL_HORSES_SELECT_ALL = "SELECT * from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_NAME = "SELECT name from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_NAME = "SELECT name, age, wins from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_YEAR = "SELECT name, years, wins from horses where years=?";
    //language=sql
    public static final String SQL_HORSES_INSERT = "INSERT INTO horses(name,age, wins) values(?,?,?) ";
    //language=sql
    public static final String SQL_HORSES_DELETE_ALL = "DELETE from horses";
    //language=sql
    public static final String SQL_HORSES_DELETE_BY_NAME = "DELETE from horses where name=?";

    //language=sql
    public static final String SQL_USERS_SELECT_ALL = "SELECT * from users";
    //language=sql
    public static final String SQL_USERS_SELECT_BY_NAME = "SELECT name, surname, account from users where name=?";
    //language=sql
    public static final String SQL_USERS_SELECT_BY_LOGIN = "SELECT name, surname from users where login=?";
    //language=sql
    public static final String SQL_USERS_SELECT_PASSWORD_BY_LOGIN = "SELECT password from users where login=?";
    //language=sql
    public static final String SQL_USERS_INSERT = "INSERT INTO users(name, surname, login, password, usertype_id, account) " +
            "values (?,?,?,?,0,0.0)";
    //language=sql
    public static final String SQL_USERS_SELECT_LOGIN = "SELECT login from users";
}
