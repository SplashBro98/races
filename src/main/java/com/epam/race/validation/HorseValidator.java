package com.epam.race.validation;

public class HorseValidator {

    private static final String NAME_REGEX = "[a-zA-Z0-9А-Яа-я_ -]{4,30}";
    private static final String AGE_REGEX = "^[1-9]?[0-9]+$";

    public boolean isCorrectName(String name){
        return name.matches(NAME_REGEX);
    }

    public boolean isCorrectAge(String age){
        return age.matches(AGE_REGEX);
    }
}
