package task.epam.race.specification.user;

import task.epam.race.entity.User;
import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserSpecification implements SQLSpecification {


    private User user;

    public DeleteUserSpecification(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction function) throws RepositoryException {
        try {
            PreparedStatement statement = (PreparedStatement) function.apply(SqlUserConstant.SQL_USERS_REMOVE_BY_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setLong(1, user.getUserId());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
