package task.epam.race.specification.buyer;

import com.viazovski.flowerauction.specification.SqlSpecification;
import com.viazovski.flowerauction.repository.SqlCheckedFunction;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectBuyerByLoginAndPasswordSpecification implements SqlSpecification {

    @Language("SQL")
    private static final String QUERY = "SELECT * FROM `buyer` WHERE `login` = ? AND `password` = ?";

    private String login;

    private String password;

    public SelectBuyerByLoginAndPasswordSpecification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public PreparedStatement getStatement(SqlCheckedFunction<String, PreparedStatement> statementGetter) throws SQLException {
        PreparedStatement statement = statementGetter.apply(QUERY);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }
}
