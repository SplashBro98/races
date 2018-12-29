package com.epam.race.specification.bet;

import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditBetSpecification implements SQLSpecification {

    private int betId;
    private double coeff;

    public EditBetSpecification(int betId, double coeff) {
        this.betId = betId;
        this.coeff = coeff;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlBetConstant.SQL_BETS_UPDATE_COEFF);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setDouble(1,coeff);
            statement.setInt(2,betId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
