package com.epam.race.util.validation;

public class BetValidator {

    private static final String COEFF_REGEX = "^((?!0\\.00)(0[.,]\\d{2}|([1-9]\\d{0,3})([.,]\\d{2})?))$";
    private static final String SUM_REGEX = "^((?!0\\.00)(0[.,]\\d{2}|([1-9]\\d{0,5})([.,]\\d{2})?))$";

    public boolean isCorrectCoeff(String coeff){
        return coeff.matches(COEFF_REGEX);
    }

    public boolean isCorrectSum(String sum){
        return sum.matches(SUM_REGEX);
    }
}
