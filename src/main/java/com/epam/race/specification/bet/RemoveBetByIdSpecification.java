package com.epam.race.specification.bet;

import com.epam.race.exception.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveBetByIdSpecification implements SQLSpecification {

    private int betId;

    public RemoveBetByIdSpecification(int betId) {
        this.betId = betId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlBetConstant.SQL_BETS_REMOVE_BY_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setInt(1, betId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
