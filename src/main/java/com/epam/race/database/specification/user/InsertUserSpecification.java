package com.epam.race.database.specification.user;

import com.epam.race.entity.user.User;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserSpecification implements SQLSpecification {

    private User user;

    public InsertUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlUserConstant.SQL_USERS_INSERT);
            fillStatement(statement);
            return statement;
        } catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException{
        try {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getUserType().getUserTypeId());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
