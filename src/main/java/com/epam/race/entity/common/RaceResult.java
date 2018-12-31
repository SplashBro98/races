package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

public class RaceResult implements Entity {
    private Race race;
    private String firstHorseName;
    private String secondHorseName;
    private String thirdHorseName;
    private String fourthHorseName;


    public RaceResult() {
    }

    public RaceResult(Race race, String firstHorseName, String secondHorseName,
                      String thirdHorseName, String fourthHorseName) {
        this.race = race;
        this.firstHorseName = firstHorseName;
        this.secondHorseName = secondHorseName;
        this.thirdHorseName = thirdHorseName;
        this.fourthHorseName = fourthHorseName;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getFirstHorseName() {
        return firstHorseName;
    }

    public void setFirstHorseName(String firstHorseName) {
        this.firstHorseName = firstHorseName;
    }

    public String getSecondHorseName() {
        return secondHorseName;
    }

    public void setSecondHorseName(String secondHorseName) {
        this.secondHorseName = secondHorseName;
    }

    public String getThirdHorseName() {
        return thirdHorseName;
    }

    public void setThirdHorseName(String thirdHorseName) {
        this.thirdHorseName = thirdHorseName;
    }

    public String getFourthHorseName() {
        return fourthHorseName;
    }

    public void setFourthHorseName(String fourthHorseName) {
        this.fourthHorseName = fourthHorseName;
    }
}
