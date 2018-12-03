package task.epam.race.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.epam.race.pool.ProxyConnection;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;


public enum ConnectionLoader {
    INSTANCE;
    private static Logger logger = LogManager.getLogger(ConnectionLoader.class);
    private ResourceBundle bundle = ResourceBundle.getBundle("db");

    public ProxyConnection loadConnection(){
        String userName = bundle.getString("username");
        String password = bundle.getString("password");
        String url = bundle.getString("url");
        String className = bundle.getString("classname");
        try {
            Class.forName(className);
            return new ProxyConnection(DriverManager.getConnection(url, userName, password));
        } catch (ClassNotFoundException | SQLException e) {
            logger.fatal("error while load connection", e);
            throw new RuntimeException(e);
        }
    }

}
