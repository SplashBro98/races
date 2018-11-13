package task.epam.race.repository.old;

import com.viazovski.flowerauction.exception.RepositoryException;
import com.viazovski.flowerauction.specification.SqlSpecification;

import java.util.List;

public interface Repository<T> {

    void add(T item) throws RepositoryException;

    void remove(T item) throws RepositoryException;

    void removeIf(SqlSpecification spec) throws RepositoryException;

    void update(T item) throws RepositoryException;

    void updateWhere(SqlSpecification spec) throws RepositoryException;

    List<T> query(SqlSpecification spec) throws RepositoryException;
}
