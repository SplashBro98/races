package task.epam.race.repository_my;

import task.epam.race.specification_my.Specification;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    boolean add(T t) throws SQLException;
    boolean remove(T t) throws SQLException;
    void update(T t) throws SQLException;

    List<T> query(Specification specification) throws SQLException;
}
