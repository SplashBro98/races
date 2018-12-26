package com.epam.race.util.validation;

public class RaceValidator {

    private static final String NAME_REGEX = "[a-zA-Z0-9А-Яа-я_ -]{4,30}";
    private static final String PLACE_REGEX = "[a-zA-Z0-9А-Яа-я_ -]{4,30}";
    private static final String TIME_REGEX = "^([0-1]\\d|2[0-3])(:[0-5]\\d)";
    private static final String DATE_REGEX = "\\d\\d\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";


    public boolean checkName(String name){
        return name.matches(NAME_REGEX);
    }

    public boolean checkPlace(String place){
        return place.matches(PLACE_REGEX);
    }

    public boolean checkTime(String time) {
        return time.matches(TIME_REGEX);
    }

    public boolean checkDate(String date) {
        return date.matches(DATE_REGEX);
    }

}
