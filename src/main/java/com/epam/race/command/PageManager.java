package com.epam.race.command;

import java.util.ResourceBundle;

public enum PageManager {
    INSTANCE;

    private ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static final String PATH_LOGIN_PAGE = "PATH_LOGIN_PAGE";
    public static final String PATH_MAIN_PAGE = "PATH_MAIN_PAGE";
    public static final String PATH_USER_PROFILE_PAGE = "PATH_USER_PROFILE_PAGE";
    public static final String PATH_ERROR_PAGE = "PATH_ERROR_PAGE";
    public static final String PATH_SIGN_UP_PAGE = "PATH_SIGN_UP_PAGE";
    public static final String PATH_ADD_HORSE_PAGE = "PATH_ADD_HORSE_PAGE";
    public static final String PATH_ADD_RACE_PAGE = "PATH_ADD_RACE_PAGE";
    public static final String PATH_ADD_BET_PAGE = "PATH_ADD_BET_PAGE";
    public static final String PATH_DELETE_HORSE_PAGE = "PATH_DELETE_HORSE_PAGE";
    public static final String PATH_RACE_PAGE = "PATH_RACE_PAGE";
    public static final String PATH_ENTER_SUM_PAGE = "PATH_ENTER_SUM_PAGE";
    public static final String PATH_HOLD_RACE_PAGE = "PATH_HOLD_RACE_PAGE";

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
