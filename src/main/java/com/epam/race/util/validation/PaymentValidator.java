package com.epam.race.util.validation;

public class PaymentValidator {

    private static final String ID_REGEX = "^\\d\\d-\\d\\d\\d-\\d\\d\\d$";
    private static final String SUM_REGEX = "^[0-9]*[.,]?[0-9]+$";

    public boolean isCorrectPaymentId(String paymentId){
        return paymentId.matches(ID_REGEX);
    }

    public boolean isCorrectSum(String sum){
        return sum.matches(SUM_REGEX);
    }
}
