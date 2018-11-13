package task.epam.race.repository_my;

import task.epam.race.entity.User;
import task.epam.race.pool.ConnectionPool;
import task.epam.race.specification_my.Specification;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static task.epam.race.constant.SqlConstant.*;

public enum UserRepository implements Repository<User> {
    INSTANCE;

    private Connection connection = ConnectionPool.getInstance().takeConnection();

    @Override
    public boolean add(User user) throws SQLException {
        ResultSet resultSet = connection.prepareStatement(SQL_USERS_SELECT_LOGIN).executeQuery();
        boolean flag = true;
        while (resultSet.next()){
            if(resultSet.getString("login").equals(user.getLogin())){
                flag = false;
                break;
            }
        }
        if(flag){
            PreparedStatement statement = connection.prepareStatement(SQL_USERS_INSERT);
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getLogin());
            statement.setString(4,user.getPassword());
            statement.execute();
        }
        return flag;
    }

    @Override
    public boolean remove(User user) throws SQLException {
        return false;
    }

    @Override
    public void update(User user) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> query(Specification specification) throws SQLException {
        ResultSet resultSet = specification.getPreparedStatement().executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("user_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String login = resultSet.getString("login");
            int userType = resultSet.getInt("userType");
            String password = resultSet.getString("password");
            BigDecimal account = resultSet.getBigDecimal("account");
            User user = new User(id, name, surname, login, password, userType, account);
            users.add(user);
        }
        return users;
    }
}
