package com.epam.race.specification.bet;

import com.epam.race.entity.Bet;
import com.epam.race.exception.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

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
            statement.setInt(2, bet.getRaceId());
            statement.setDouble(3, bet.getCoeff());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
