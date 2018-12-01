package task.epam.race.servlet;

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
//    private static Logger logger = LogManager.getLogger(ConnectionLoader.class);
//
//    public void loadConnections(BlockingQueue<ProxyConnection> queue){
//        try {
//
//            Class.forName("org.postgresql.Driver");
//
//            String url = bundle.getString("db.url");
//            String password = bundle.getString("db.password");
//            String name = bundle.getString("db.username");
//            //String driverClassName = bundle.getString("db.classname");
//            //System.out.println(driverClassName);
//
//
//
//            for (int i = 0; i < queue.size(); i++) {
//                queue.add(new ProxyConnection(DriverManager.getConnection(url, name, password)));
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            logger.log(Level.ERROR,"Problem with connection to database");
//            e.printStackTrace();
//        }
//
//    }

    public void loadConnections(BlockingQueue<ProxyConnection> queue, int size){

    }
}
