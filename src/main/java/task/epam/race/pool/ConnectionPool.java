package task.epam.race.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
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

    public static final int MAX_POOL_SIZE = 15;
    private static BlockingQueue<ProxyConnection> avaliableConnections = new LinkedBlockingQueue<>(MAX_POOL_SIZE);
    private static BlockingQueue<ProxyConnection> usedConnections = new LinkedBlockingQueue<>(MAX_POOL_SIZE);


    private ConnectionPool() {

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
    public void addConnection(ProxyConnection proxyConnection){
        try {
            avaliableConnections.put(proxyConnection);
            //logger.log(Level.INFO, "addConnection: size of avaliable: " + avaliableConnections.size());
        }catch (InterruptedException e){
            logger.error("Can`t put ProxyConnection to queue",e);
        }
    }

    public Connection takeConnection(){
        ProxyConnection connection = null;
        try {
            connection = avaliableConnections.take();
            //logger.log(Level.INFO, "takeConnection: size of avaliable: " + avaliableConnections.size());
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return connection;
    }
    public void returnConnection(Connection connection){
        if(connection instanceof ProxyConnection){
            try {
                ProxyConnection realConnection = (ProxyConnection) connection;
                avaliableConnections.put(realConnection);
                //logger.log(Level.INFO, "returnConnection: size of avaliable: " + avaliableConnections.size());
                usedConnections.remove(realConnection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void close(){
        for (int i = 0; i < avaliableConnections.size(); i++) {
            try {
                ProxyConnection connection = avaliableConnections.take();
                connection.realClose();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < usedConnections.size(); i++) {
            try {
                ProxyConnection connection = usedConnections.take();
                connection.realClose();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
