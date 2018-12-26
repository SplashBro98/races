package com.epam.race.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.race.pool.ConnectionPool;
import com.epam.race.specification.SQLSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T>{

    private static Logger logger = LogManager.getLogger(AbstractRepository.class);


    public abstract T createItem(ResultSet resultSet) throws RepositoryException;

    protected void nonSelectQuery(SQLSpecification specification) throws RepositoryException{
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = specification.getStatement(connection::prepareStatement)) {
            statement.execute();

        } catch (SQLException e) {
            logger.error("Problem with connection with database",e);
            throw new RepositoryException(e);
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
           logger.error("Problem with connection with database",e);
           throw new RepositoryException(e);
        }
    }
}
