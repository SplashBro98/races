package com.epam.race.util.validation;

public class BetValidator {

    private static final String COEFF_REGEX = "^[0-9]*[.,]?[0-9]+$";
    private static final String SUM_REGEX = "^[0-9]*[.,]?[0-9]+$";

    public boolean isCorrectCoeff(String coeff){
        return coeff.matches(COEFF_REGEX);
    }

    public boolean isCorrectSum(String sum){
        return sum.matches(SUM_REGEX);
    }
}
