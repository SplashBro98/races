package com.epam.race.service;

import com.epam.race.entity.Payment;
import com.epam.race.repository.RepositoryException;
import com.epam.race.repository.impl.PaymentRepository;
import com.epam.race.specification.SQLSpecification;
import com.epam.race.specification.payment.SelectPaymentByIdSpecification;

import java.util.List;
import java.util.Optional;

public class PaymentService {

    public void addPayment(Payment payment) throws ServiceException {
        try{
            PaymentRepository.getInstance().add(payment);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public Optional<Payment> findPaymentById(String paymentId) throws ServiceException {
        try{
            SQLSpecification sqlSpecification = new SelectPaymentByIdSpecification(paymentId);
            List<Payment> paymentList = PaymentRepository.getInstance().query(sqlSpecification);
            if(paymentList.isEmpty()){
                return Optional.empty();
            }
            return Optional.of(paymentList.get(0));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}