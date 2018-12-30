package com.epam.race.database.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.util.constant.StringConstant;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public enum ConnectionLoader {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ConnectionLoader.class);
    private ResourceBundle bundle = ResourceBundle.getBundle(StringConstant.DB);

    public ProxyConnection loadConnection(){
        String userName = bundle.getString(StringConstant.USERNAME);
        String password = bundle.getString(StringConstant.PASSWORD);
        String url = bundle.getString(StringConstant.URL);
        String className = bundle.getString(StringConstant.CLASSNAME);
        try {
            Class.forName(className);
            return new ProxyConnection(DriverManager.getConnection(url, userName, password));
        } catch (ClassNotFoundException | SQLException e) {
            logger.fatal("error while load connection", e);
            throw new RuntimeException(e);
        }
    }

}
