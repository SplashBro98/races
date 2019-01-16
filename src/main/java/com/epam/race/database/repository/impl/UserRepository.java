package com.epam.race.database.repository.impl;

import com.epam.race.database.ColumnName;
import com.epam.race.entity.user.User;
import com.epam.race.entity.user.UserType;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.user.InsertUserSpecification;
import com.epam.race.database.specification.user.DeleteUserSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {


    public static final String COLUMN_IS_LOCKED = "is_locked";
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
            newUser.setUserId(resultSet.getInt(1));
            newUser.setName(resultSet.getString(ColumnName.NAME));
            newUser.setSurname(resultSet.getString(ColumnName.SURNAME));
            newUser.setLogin(resultSet.getString(ColumnName.LOGIN));
            newUser.setPassword(resultSet.getString(ColumnName.PASSWORD));
            newUser.setEmail(resultSet.getString(ColumnName.EMAIL));
            int type = resultSet.getInt(ColumnName.USERTYPE_ID);
            if(type == 1) {
                newUser.setAmount(resultSet.getBigDecimal(ColumnName.AMOUNT));
            }
            newUser.setLocked(resultSet.getBoolean(COLUMN_IS_LOCKED));

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
            throw new RepositoryException("SQL Exception in createItem method", e);
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
