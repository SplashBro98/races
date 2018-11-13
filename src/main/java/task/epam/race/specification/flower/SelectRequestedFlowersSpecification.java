package task.epam.race.specification.flower;


import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRequestedFlowersSpecification implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY =
            "SELECT * FROM `flower` " +
            "WHERE `flower_id` IN (" +
                "SELECT DISTINCT `flower_id` FROM `flower` " +
                "WHERE `auction_id` IS NOT NULL AND `flower_accepted` = FALSE)";

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        return statementGetter.apply(QUERY);
    }
}
