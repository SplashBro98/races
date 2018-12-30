package com.epam.race.database.specification.payment;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectPaymentByIdSpecification implements SQLSpecification {

    private String paymentId;

    public SelectPaymentByIdSpecification(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlPaymentConstant.SQL_PAYMENTS_SELECT_BY_ID);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setString(1,paymentId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
