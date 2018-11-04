package task.epam.race.specification;

import task.epam.race.entity.Horse;

public class AllHorsesSpecification implements Specification<Horse> {
    @Override
    public boolean specify(Horse horse) {
        return true;
    }
}
