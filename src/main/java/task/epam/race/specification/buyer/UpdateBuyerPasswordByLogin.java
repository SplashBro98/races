package task.epam.race.specification.buyer;

import com.viazovski.flowerauction.specification.SqlSpecification;
import com.viazovski.flowerauction.repository.SqlCheckedFunction;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBuyerPasswordByLogin implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY = "UPDATE `buyer` SET `password` = ? WHERE `login` = ?";

    private String login;

    private String password;

    public UpdateBuyerPasswordByLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        PreparedStatement statement = statementGetter.apply(QUERY);
        statement.setString(1, password);
        statement.setString(2, login);
        return statement;
    }
}
