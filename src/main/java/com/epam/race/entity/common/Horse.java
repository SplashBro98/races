package com.epam.race.entity.common;

import com.epam.race.entity.Entity;

import java.util.Objects;

public class Horse implements Entity {
    private int horseId;
    private String name;
    private int age;
    private int wins;

    public Horse() {
    }

    public Horse(String name) {
        this.name = name;
    }

    public Horse(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Horse(int horseId, String name, int age) {
        this.horseId = horseId;
        this.name = name;
        this.age = age;
    }

    public Horse(String name, int age, int wins) {
        this.name = name;
        this.age = age;
        this.wins = wins;
    }

    public Horse(int horseId, String name, int age, int wins) {
        this.horseId = horseId;
        this.name = name;
        this.age = age;
        this.wins = wins;
    }

    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return age == horse.age &&
                wins == horse.wins &&
                name.equals(horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, wins);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "horseId=" + horseId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wins=" + wins +
                '}';
    }
}
