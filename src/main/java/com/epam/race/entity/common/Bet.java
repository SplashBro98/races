package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

public class Bet implements Entity {
    private int betId;
    private Race race;
    private Horse horse;
    private int position;
    private double coeff;

    public Bet() {
    }



    public Bet(Race race, double coeff) {
        this.race = race;
        this.coeff = coeff;
    }

    public Bet(int betId, Race race, Horse horse, double coeff) {
        this.betId = betId;
        this.race = race;
        this.horse = horse;
        this.coeff = coeff;
    }

    public Bet(int betId, Race race, Horse horse, int position, double coeff) {
        this.betId = betId;
        this.race = race;
        this.horse = horse;
        this.position = position;
        this.coeff = coeff;
    }
    public Bet(Race race, Horse horse, int position, double coeff) {
        this.betId = betId;
        this.race = race;
        this.horse = horse;
        this.position = position;
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

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
