package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Race implements Entity {
    private int raceId;
    private String name;
    private String place;
    private LocalDate date;
    private LocalTime time;

    private List<Bet> bets = new ArrayList<>();
    private List<Horse> horses = new ArrayList<>();

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

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList(bets);
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void addHorse(Horse horse){
        horses.add(horse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return name.equals(race.name) &&
                place.equals(race.place) &&
                date.equals(race.date) &&
                time.equals(race.time) &&
                bets.equals(race.bets) &&
                horses.equals(race.horses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, date, time, bets, horses);
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
