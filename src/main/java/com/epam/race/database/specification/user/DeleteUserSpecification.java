package com.epam.race.database.specification.user;

import com.epam.race.entity.User;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserSpecification implements SQLSpecification {


    private User user;

    public DeleteUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction function) throws RepositoryException {
        try {
            PreparedStatement statement = (PreparedStatement) function.apply(SqlUserConstant.SQL_USERS_REMOVE_BY_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setLong(1, user.getUserId());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
