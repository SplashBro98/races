package task.epam.race.entity;

public class Horse implements Entity {
    private int horseId;
    private String name;
    private int age;
    private int wins;

    public Horse(int horseId, String name, int age, int wins) {
        this.horseId = horseId;
        this.name = name;
        this.age = age;
        this.wins = wins;
    }

    public Horse(String name, int age, int wins) {
        this.name = name;
        this.age = age;
        this.wins = wins;
    }

    public String getName() {
        return name;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
