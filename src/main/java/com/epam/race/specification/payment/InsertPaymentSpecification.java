package com.epam.race.specification.payment;

import com.epam.race.entity.Payment;
import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPaymentSpecification implements SQLSpecification {

    private Payment payment;

    public InsertPaymentSpecification(Payment payment) {
        this.payment = payment;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlPaymentConstant.SQL_PAYMENTS_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setString(1,payment.getPaymentId());
            statement.setBigDecimal(2,payment.getSum());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}


