package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

import java.util.Objects;

public class RaceResult implements Entity {
    private Race race;
    private String firstHorseName;
    private String secondHorseName;
    private String thirdHorseName;
    private String fourthHorseName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult that = (RaceResult) o;
        return race.equals(that.race) &&
                firstHorseName.equals(that.firstHorseName) &&
                secondHorseName.equals(that.secondHorseName) &&
                thirdHorseName.equals(that.thirdHorseName) &&
                fourthHorseName.equals(that.fourthHorseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race, firstHorseName, secondHorseName, thirdHorseName, fourthHorseName);
    }

    @Override
    public String toString() {
        return "RaceResult{" +
                "race=" + race +
                ", firstHorseName='" + firstHorseName + '\'' +
                ", secondHorseName='" + secondHorseName + '\'' +
                ", thirdHorseName='" + thirdHorseName + '\'' +
                ", fourthHorseName='" + fourthHorseName + '\'' +
                '}';
    }
}
