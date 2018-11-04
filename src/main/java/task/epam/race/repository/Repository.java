package task.epam.race.repository;

import task.epam.race.specification.Specification;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    //language=sql
    public static final String SQL_HORSE_SELECT_ALL = "SELECT * from horse";
    //language=sql
    public static final String SQL_HORSE_SELECT_NAME = "SELECT name from horse";
    //language=sql
    public static final String SQL_HORSE_SELECT_BY_NAME = "SELECT name, years, wins from horse where name=?";
    //language=sql
    public static final String SQL_HORSE_SELECT_BY_YEAR = "SELECT name, years, wins from horse where years=?";
    //language=sql
    public static final String SQL_HORSE_INSERT = "INSERT INTO horse(name,years, wins) values(?,?,?) ";
    //language=sql
    public static final String SQL_HORSE_DELETE_ALL = "DELETE from horse";
    //language=sql
    public static final String SQL_HORSE_DELETE_BY_NAME = "DELETE from horse where name=?";

    boolean add(T t) throws SQLException;
    boolean remove(T t) throws SQLException;
    void update(T t) throws SQLException;

    List<T> query(Specification specification) throws SQLException;
}
