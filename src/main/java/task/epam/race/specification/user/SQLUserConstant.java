package task.epam.race.specification.user;

public final class SQLUserConstant {

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
}
