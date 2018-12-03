package task.epam.race.specification;

import task.epam.race.exception.RepositoryException;

import java.sql.SQLException;


@FunctionalInterface
public interface SQLFunction<T,K, E extends SQLException> {
    K apply(T t) throws E;
}
