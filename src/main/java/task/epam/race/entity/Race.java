package task.epam.race.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Race implements Entity {
    private int raceId;
    private String name;
    private String place;
    private LocalDate date;
    private LocalTime time;

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
}
