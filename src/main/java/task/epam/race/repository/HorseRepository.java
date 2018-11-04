package task.epam.race.repository;

import task.epam.race.entity.Horse;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.specification.Specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum HorseRepository implements Repository<Horse> {
    INSTANCE;

    private Connection connection = ConnectionPool.getInstance().takeConnection();



    @Override
    public boolean add(Horse horse) throws SQLException {
        ResultSet resultSet = this.connection.prepareStatement(SQL_HORSE_SELECT_NAME).executeQuery();
        boolean flag = true;
        while (resultSet.next()){
            if(resultSet.getString("name").equals(horse.getName())){
                flag = false;
            }
        }
        if(flag) {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_HORSE_INSERT);
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
        List<Horse> horses = new ArrayList<>();
        ResultSet resultSet = this.connection.prepareStatement(SQL_HORSE_SELECT_ALL).executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int age = resultSet.getInt("years");
            int wins = resultSet.getInt("wins");
            Horse horse = new Horse(name, age, wins);
            if(specification.specify(horse)){
                horses.add(horse);
            }
        }
        return horses;
    }
}
