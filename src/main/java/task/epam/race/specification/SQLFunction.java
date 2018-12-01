package task.epam.race.specification;

import java.sql.SQLException;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface SQLFunction<T,K>{
    K apply(T t) throws SQLException;
}
