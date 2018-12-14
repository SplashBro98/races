package task.epam.race.entity;

import java.math.BigDecimal;

public class Bet implements Entity {
    private int betId;
    private Race race;
    private String describe;
    private double coeff;

    public Bet() {
    }

    public Bet(int betId, Race race, double coeff) {
        this.betId = betId;
        this.race = race;
        this.coeff = coeff;
    }

    public Bet(Race race, double coeff) {
        this.race = race;
        this.coeff = coeff;
    }

    public Bet(int betId, Race race, String describe, double coeff) {
        this.betId = betId;
        this.race = race;
        this.describe = describe;
        this.coeff = coeff;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
