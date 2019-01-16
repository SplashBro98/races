package com.epam.race.validation;

import com.epam.race.entity.common.Race;
import com.epam.race.service.RaceService;
import com.epam.race.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class RaceValidator {

    private static final String NAME_REGEX = "[a-zA-Z0-9А-Яа-я_ \\-']{4,40}";
    private static final String PLACE_REGEX = "[a-zA-Z0-9А-Яа-я_ \\-']{4,40}";
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

    public boolean isDifferentHorses(List<Integer> horseIdList) {
        for(int i : horseIdList){
            if(horseIdList.stream().filter(id -> id.equals(i)).count() != 1){
                return false;
            }
        }
        return true;
    }

    public boolean checkNameIsPresent(String name) throws ServiceException {
        List<Race> races = new RaceService().findAllRaces();
        List<String> raceNameList = new ArrayList<>();
        races.forEach(r -> raceNameList.add(r.getName()));
        return raceNameList.contains(name);
    }

}
