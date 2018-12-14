package task.epam.race.specification.bet;

import task.epam.race.entity.Bet;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.Repository;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBetSpecification implements SQLSpecification {

    private Bet bet;

    public InsertBetSpecification(Bet bet) {
        this.bet = bet;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlBetConstant.SQL_BETS_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setString(1,bet.getDescribe());
            statement.setInt(2, bet.getRace().getRaceId());
            statement.setDouble(3, bet.getCoeff());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
