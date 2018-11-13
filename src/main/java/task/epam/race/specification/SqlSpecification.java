package task.epam.race.specification;

import com.viazovski.flowerauction.repository.SqlCheckedFunction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlSpecification {

    PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException;
}
