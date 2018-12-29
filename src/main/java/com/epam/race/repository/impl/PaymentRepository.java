package com.epam.race.repository.impl;

import com.epam.race.entity.Payment;
import com.epam.race.repository.AbstractRepository;
import com.epam.race.repository.RepositoryException;
import com.epam.race.specification.SQLSpecification;

import java.sql.ResultSet;
import java.util.List;

public class PaymentRepository extends AbstractRepository<Payment> {

    @Override
    public Payment createItem(ResultSet resultSet) throws RepositoryException {
        return null;
    }

    @Override
    public void add(Payment payment) throws RepositoryException {

    }

    @Override
    public void remove(Payment payment) throws RepositoryException {

    }

    @Override
    public void update(SQLSpecification specification) throws RepositoryException {

    }

    @Override
    public List<Payment> query(SQLSpecification specification) throws RepositoryException {
        return null;
    }
}
