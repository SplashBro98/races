package task.epam.race.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static BlockingQueue<ProxyConnection> avaliableConnections = new LinkedBlockingQueue<>();
    private static BlockingQueue<ProxyConnection> usedConnections = new LinkedBlockingQueue<>();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);

    private ConnectionPool() {
        init();
    }
    private void init(){

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
        avaliableConnections.add(proxyConnection);
        System.out.println("SIZE: " + avaliableConnections.size());
    }

    public Connection takeConnection(){
        ProxyConnection connection = null;
        try {
            connection = avaliableConnections.take();
            System.out.println("SIZE: " + avaliableConnections.size());
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void returnConnection(Connection connection){
        if(connection instanceof ProxyConnection){
            try {
                ProxyConnection realConnection = (ProxyConnection) connection;
                avaliableConnections.put(realConnection);
                System.out.println("SIZE: " + avaliableConnections.size());
                usedConnections.remove(realConnection);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
