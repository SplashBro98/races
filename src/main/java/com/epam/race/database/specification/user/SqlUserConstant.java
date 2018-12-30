package com.epam.race.database.specification.user;

public final class SqlUserConstant {

    //language=sql
    static final String SQL_USERS_SELECT_ALL = "SELECT * from users";
    //language=sql
    static final String SQL_USERS_SELECT_ALL_USERS = "SELECT * from users where usertype_id = 1";
    //language=sql
    static final String SQL_USERS_SELECT_BY_NAME = "SELECT * from users where name=?";
    //language=sql
    static final String SQL_USERS_SELECT_BY_LOGIN = "SELECT * from users where login=?";
    //language=sql
    static final String SQL_USERS_SELECT_BY_ID = "SELECT * from users where userid=?";
    //language=sql
    static final String SQL_USERS_SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * from users where login = ?" +
            " and password = ?";
    //language=sql
    static final String SQL_USERS_SELECT_PASSWORD_BY_LOGIN = "SELECT password from users where login=?";
    //language=sql
    static final String SQL_USERS_INSERT = "INSERT INTO users(name, surname, login, password,email," +
            "usertype_id, amount,is_locked) " +
            "values (?,?,?,?,?,?,0,false)";
    //language=sql
    static final String SQL_USERS_REMOVE_BY_ID = "DELETE from users where user_id = ?";

    //language=sql
    static final String SQL_USERS_UPDATE_AMOUNT = "update users set amount = ? where login = ?";

    //language=sql
    static final String SQL_USERS_UPDATE = "update users set name = ?, surname = ?, " +
            "login = ?, password = ?, email = ?" +
            "where userid = ?";
    //language=sql
    static final String SQL_USERS_BLOCK_USER = "update users set is_locked = true where login = ?";

    //language=sql
    static final String SQL_USERS_UNLOCK_USER = "update users set is_locked = false where login = ?";
}
