package com.epam.race.util.validation;

public class PaymentValidator {

    private static final String ID_REGEX = "^\\d{2}-\\d{3}-\\d{3}$";
    private static final String SUM_REGEX = "^((?!0\\.00)(0[.,]\\d{2}|([1-9]\\d{0,5})([.,]\\d{2})?))$";

    public boolean isCorrectPaymentId(String paymentId){
        return paymentId.matches(ID_REGEX);
    }

    public boolean isCorrectSum(String sum){
        return sum.matches(SUM_REGEX);
    }
}
