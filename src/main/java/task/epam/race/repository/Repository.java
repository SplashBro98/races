package task.epam.race.repository;

import task.epam.race.specification.SQLSpecification;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    void add(T t) throws SQLException;
    void remove(T t) throws SQLException;
    void update(T t) throws SQLException;

    List<T> query(SQLSpecification specification) throws SQLException;
}
