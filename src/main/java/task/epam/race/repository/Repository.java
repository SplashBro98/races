package task.epam.race.repository;

import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLSpecification;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    void add(T t) throws RepositoryException;
    void remove(T t) throws RepositoryException;
    void update(T t) throws RepositoryException;

    List<T> query(SQLSpecification specification) throws RepositoryException;
}
