package task.epam.race.util.constant;

public final class SQLConstant {
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
    public static final String SQL_USERS_SELECT_BY_NAME = "SELECT * from users where name=?";
    //language=sql
    public static final String SQL_USERS_SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * from users where login = ?" +
            " and password = ?";
    //language=sql
    public static final String SQL_USERS_SELECT_PASSWORD_BY_LOGIN = "SELECT password from users where login=?";
    //language=sql
    public static final String SQL_USERS_INSERT = "INSERT INTO users(name, surname, login, password,email,usertype_id) " +
            "values (?,?,?,?,?,?)";
    //language=sql
    public static final String SQL_USERS_REMOVE_BY_ID = "DELETE from users where user_id = ?";
    //language=sql
    public static final String SQL_USERS_SELECT_LOGIN = "SELECT login from users";
}
