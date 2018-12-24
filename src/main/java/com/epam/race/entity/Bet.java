package com.epam.race.entity;

public class Bet implements Entity {
    private int betId;
    private int raceId;
    private String describe;
    private double coeff;

    public Bet() {
    }

    public Bet(int betId, int raceId, double coeff) {
        this.betId = betId;
        this.raceId = raceId;
        this.coeff = coeff;
    }

    public Bet(int raceId, double coeff) {
        this.raceId = raceId;
        this.coeff = coeff;
    }

    public Bet(int raceId, String describe, double coeff) {
        this.raceId = raceId;
        this.describe = describe;
        this.coeff = coeff;
    }

    public Bet(int betId, int raceId, String describe, double coeff) {
        this.betId = betId;
        this.raceId = raceId;
        this.describe = describe;
        this.coeff = coeff;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
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
