package task.epam.race.specification;

import task.epam.race.entity.Horse;

public class HorseWinsSpecification implements Specification<Horse> {
    private int win;

    public HorseWinsSpecification(int win) {
        this.win = win;
    }


    @Override
    public boolean specify(Horse horse) {
        return horse.getWins() > win;
    }
}
