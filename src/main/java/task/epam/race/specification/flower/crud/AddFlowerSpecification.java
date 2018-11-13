package task.epam.race.specification.flower.crud;

import com.viazovski.flowerauction.model.Flower;
import com.viazovski.flowerauction.repository.SqlCheckedFunction;
import com.viazovski.flowerauction.specification.SqlSpecification;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddFlowerSpecification implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY =
            "INSERT INTO `flower` " +
            "(`auction_id`, `owner_id`, `flower_accepted`, `name`, `value`) " +
            "VALUES (?, ?, ?, ?, ?)";

    private Flower flower;

    public AddFlowerSpecification(Flower flower) {
        this.flower = flower;
    }

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        PreparedStatement statement = statementGetter.apply(QUERY);
        fillWithValues(statement);
        return statement;
    }

    private void fillWithValues(PreparedStatement statement) throws SQLException {
        statement.setInt(1, flower.getAuctionId());
        statement.setInt(2, flower.getOwnerId());
        statement.setBoolean(3, flower.isFlowerAccepted());
        statement.setString(4, flower.getName());
        statement.setInt(5, flower.getValue());
    }
}
