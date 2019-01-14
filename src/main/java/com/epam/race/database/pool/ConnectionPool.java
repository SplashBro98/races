package com.epam.race.database.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);

    private static final int MAX_POOL_SIZE = 15;
    private static BlockingQueue<ProxyConnection> avaliableConnections = new LinkedBlockingQueue<>();
    private static BlockingQueue<ProxyConnection> usedConnections = new LinkedBlockingQueue<>();

    private ConnectionPool() {
        for (int i = 0; i < MAX_POOL_SIZE ; i++) {
            try {
                avaliableConnections.put(ConnectionLoader.INSTANCE.loadConnection());
            } catch (InterruptedException e) {
                logger.fatal("Can`t put ProxyConnection to queue",e);
                throw new RuntimeException(e);
            }
        }

    }

    public static ConnectionPool getInstance(){
        if(!isCreated.get()){
            try {
                lock.lock();
                if(instance == null){
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection takeConnection(){
        ProxyConnection connection = null;
        try {
            connection = avaliableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            logger.error("Error while take connection",e);
        }
        return connection;
    }
    public void returnConnection(Connection connection){
        if(connection instanceof ProxyConnection){
            try {
                ProxyConnection realConnection = (ProxyConnection) connection;
                avaliableConnections.put(realConnection);
                usedConnections.remove(realConnection);
            } catch (InterruptedException e) {
                logger.error("Interrupted Exception in connection pool",e);
            }
        }
    }

    public void closePool(){
        for (int i = 0; i < avaliableConnections.size(); i++) {
            try {
                ProxyConnection connection = avaliableConnections.take();
                connection.realClose();
            } catch (InterruptedException | SQLException e) {
                logger.error("Error while closePool connections",e);
            }
        }
        DriverManager.drivers().forEach(x-> {
            try {
                DriverManager.deregisterDriver(x);
            } catch (SQLException e) {
                logger.error("Error while deregister drivers", e);
            }
        });
    }
}
