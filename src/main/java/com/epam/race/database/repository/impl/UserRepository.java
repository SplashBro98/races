package com.epam.race.database.repository.impl;

import com.epam.race.entity.User;
import com.epam.race.entity.UserType;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.user.InsertUserSpecification;
import com.epam.race.database.specification.user.DeleteUserSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {


    private static UserRepository instance;

    private UserRepository(){

    }

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    @Override
    public User createItem(ResultSet resultSet) throws RepositoryException {
        try {
            User newUser = new User();
            newUser.setUserId(resultSet.getInt("userId"));
            newUser.setName(resultSet.getString("name"));
            newUser.setSurname(resultSet.getString("surname"));
            newUser.setLogin(resultSet.getString("login"));
            newUser.setPassword(resultSet.getString("password"));
            newUser.setEmail(resultSet.getString("email"));
            newUser.setAmount(resultSet.getBigDecimal("amount"));
            newUser.setLocked(resultSet.getBoolean("is_locked"));
            int type = resultSet.getInt("userType_id");
            switch (type) {
                case 3:
                    newUser.setUserType(UserType.ADMIN);
                    break;
                case 1:
                    newUser.setUserType(UserType.CLIENT);
                    break;
                case 2:
                    newUser.setUserType(UserType.BOOKMAKER);
                    break;
                default:
                    newUser.setUserType(UserType.CLIENT);
                    break;
            }
            return newUser;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void add(User user) throws RepositoryException {
        nonSelectQuery(new InsertUserSpecification(user));
    }

    @Override
    public void remove(User user) throws RepositoryException {
        nonSelectQuery(new DeleteUserSpecification(user));
    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {
        nonSelectQuery(specification);
    }

    @Override
    public List<User> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
