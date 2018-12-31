package com.epam.race.database.repository.impl;

import com.epam.race.entity.common.Payment;
import com.epam.race.database.repository.AbstractRepository;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.payment.DeletePaymentSpecification;
import com.epam.race.database.specification.payment.InsertPaymentSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaymentRepository extends AbstractRepository<Payment> {

    private static PaymentRepository instance;

    private PaymentRepository(){

    }

    public static PaymentRepository getInstance(){
        if(instance == null){
            instance = new PaymentRepository();
        }
        return instance;
    }

    @Override
    public Payment createItem(ResultSet resultSet) throws RepositoryException {
        try{
            Payment payment = new Payment();
            payment.setPaymentId(resultSet.getString(1));
            payment.setSum(resultSet.getBigDecimal(2));
            return payment;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void add(Payment payment) throws RepositoryException {
        nonSelectQuery(new InsertPaymentSpecification(payment));
    }

    @Override
    public void remove(Payment payment) throws RepositoryException {
        nonSelectQuery(new DeletePaymentSpecification(payment.getPaymentId()));
    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {

    }

    @Override
    public List<Payment> query(SQLSpecification specification) throws RepositoryException {
        return selectQuery(specification);
    }
}
