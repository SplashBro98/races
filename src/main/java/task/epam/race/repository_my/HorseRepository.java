package task.epam.race.repository_my;

import task.epam.race.entity.Horse;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.specification_my.Specification;
import static task.epam.race.constant.SqlConstant.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum HorseRepository implements Repository<Horse> {
    INSTANCE;

    private Connection connection = ConnectionPool.getInstance().takeConnection();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Horse horse) throws SQLException {
        ResultSet resultSet = this.connection.prepareStatement(SQL_HORSES_SELECT_NAME).executeQuery();
        boolean flag = true;
        while (resultSet.next()){
            if(resultSet.getString("name").equals(horse.getName())){
                flag = false;
            }
        }
        if(flag) {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_HORSES_INSERT);
            preparedStatement.setString(1, horse.getName());
            preparedStatement.setInt(2, horse.getAge());
            preparedStatement.setInt(3, horse.getWins());
            preparedStatement.execute();
        }
        return flag;
    }

    @Override
    public boolean remove(Horse horse) throws SQLException{
        return false;
    }

    @Override
    public void update(Horse horse) throws SQLException{

    }

    @Override
    public List<Horse> query(Specification specification) throws SQLException{
        ResultSet resultSet = specification.getPreparedStatement().executeQuery();
        List<Horse> horses = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("horse_id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int wins = resultSet.getInt("wins");
            Horse horse = new Horse(id, name, age, wins);
            horses.add(horse);
        }
        return horses;
    }
}
