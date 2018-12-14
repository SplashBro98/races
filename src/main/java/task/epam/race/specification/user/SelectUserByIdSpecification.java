package task.epam.race.specification.user;

import task.epam.race.exception.RepositoryException;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;
import task.epam.race.specification.bet.SqlBetConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectUserByIdSpecification implements SQLSpecification {

    private int userId;

    public SelectUserByIdSpecification(int userId) {
        this.userId = userId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserConstant.SQL_USERS_SELECT_BY_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setInt(1,userId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }

    }
}
