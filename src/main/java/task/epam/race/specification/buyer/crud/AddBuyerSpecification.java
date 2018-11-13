package task.epam.race.specification.buyer.crud;

import com.viazovski.flowerauction.model.Buyer;
import com.viazovski.flowerauction.repository.SqlCheckedFunction;
import com.viazovski.flowerauction.specification.SqlSpecification;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBuyerSpecification implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY =
            "INSERT INTO `buyer` " +
            "(`first_name`, `last_name`, `dob`, `credit_card`, `login`, `password`, `lang`, `role`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private Buyer buyer;

    public AddBuyerSpecification(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        PreparedStatement statement = statementGetter.apply(QUERY);
        fillWithValues(statement);
        return statement;
    }

    private void fillWithValues(PreparedStatement statement) throws SQLException {
        statement.setString(1, buyer.getFirstName());
        statement.setString(2, buyer.getLastName());
        statement.setDate(3, buyer.getDateOfBirth());
        statement.setString(4, buyer.getCreditCard());
        statement.setString(5, buyer.getLogin());
        statement.setString(6, buyer.getPassword());
        statement.setString(7, buyer.getLanguage().name());
        statement.setString(7, buyer.getRole().name());
    }
}
