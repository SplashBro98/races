package task.epam.race.specification.user;

import task.epam.race.entity.User;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserSpecification implements SQLSpecification {

    //language=sql
    public static final String SQL_USERS_INSERT = "INSERT INTO users(name, surname, login, password, usertype_id, account) " +
            "values (?,?,?,?,0,0.0)";

    private User user;

    public InsertUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
        PreparedStatement statement = function.apply(SQL_USERS_INSERT);
        fillStatement(statement);
        return statement;
    }
    private void fillStatement(PreparedStatement statement) throws SQLException{
        statement.setString(1,user.getName());
        statement.setString(2,user.getSurname());
        statement.setString(3,user.getLogin());
        statement.setString(4,user.getPassword());
    }
}
