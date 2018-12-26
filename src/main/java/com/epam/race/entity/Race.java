package com.epam.race.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class Race implements Entity {
    private int raceId;
    private String name;
    private String place;
    private LocalDate date;
    private LocalTime time;

    private List<Bet> bets;
    private List<Horse> horses;

    public Race() {
    }

    public Race(int raceId, String name, String place, LocalDate date, LocalTime time) {
        this.raceId = raceId;
        this.name = name;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public Race(String name, String place, LocalDate date, LocalTime time) {
        this.name = name;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public void addBet(Bet bet){
        bets.add(bet);
    }

    public void removeBet(Bet bet){
        bets.remove(bet);
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList(bets);
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId=" + raceId +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
