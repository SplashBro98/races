package task.epam.race.specification.buyer;

import com.viazovski.flowerauction.model.Buyer;
import com.viazovski.flowerauction.specification.SqlSpecification;
import com.viazovski.flowerauction.repository.SqlCheckedFunction;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBuyerProfileByLogin implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY =
            "UPDATE `buyer` " +
                    "SET `first_name` = ?, `password` = ?, `last_name` = ?, `dob` = ?, `credit_card` = ? " +
                    "WHERE `login` = ?";

    private Buyer buyer;

    public UpdateBuyerProfileByLogin(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        PreparedStatement statement = statementGetter.apply(QUERY);
        statement.setString(1, buyer.getFirstName());
        statement.setString(2, buyer.getLastName());
        statement.setDate(3, buyer.getDateOfBirth());
        statement.setString(4, buyer.getCreditCard());
        statement.setString(5, buyer.getLogin());
        return statement;
    }
}
