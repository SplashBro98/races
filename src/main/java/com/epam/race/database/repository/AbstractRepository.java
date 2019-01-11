package com.epam.race.database.repository;

import com.epam.race.database.pool.ConnectionPool;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T>{

    public abstract T createItem(ResultSet resultSet) throws RepositoryException;

    protected void nonSelectQuery(SQLSpecification specification) throws RepositoryException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            statement.execute();

        } catch (SQLException e) {
            throw new RepositoryException("SQL Exception in non-select query",e);
        }
    }

    protected List<T> selectQuery(SQLSpecification specification) throws RepositoryException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (resultSet.next()){
                result.add(createItem(resultSet));
            }
            return result;
        } catch (SQLException e) {
           throw new RepositoryException("SQL Exception in select query",e);
        }
    }
}
