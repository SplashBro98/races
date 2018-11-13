package task.epam.race.repository;

import java.sql.SQLException;

public interface SqlCheckedFunction<T, R> extends CheckedFunction<T, R, SQLException> {
}
