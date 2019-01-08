package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return position == bet.position &&
                Double.compare(bet.coeff, coeff) == 0 &&
                race.equals(bet.race) &&
                horse.equals(bet.horse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race, horse, position, coeff);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
                ", race=" + race +
                ", horse=" + horse +
                ", position=" + position +
                ", coeff=" + coeff +
                '}';
    }
}
