package task.epam.race.servlet;

import java.util.ResourceBundle;

public enum ConfigurationManager {
    INSTANCE;

    private ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static final String PATH_LOGIN_PAGE = "PATH_LOGIN_PAGE";
    public static final String PATH_MAIN_PAGE = "PATH_MAIN_PAGE";
    public static final String PATH_ERROR_PAGE = "PATH_ERROR_PAGE";
    public static final String PATH_FAIL_PAGE = "PATH_FAIL_PAGE";

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
