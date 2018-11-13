package task.epam.race.repository.old;

import java.sql.SQLException;

public interface SqlCheckedFunction<T, R> extends CheckedFunction<T, R, SQLException> {
}
