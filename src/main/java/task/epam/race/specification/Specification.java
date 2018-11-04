package task.epam.race.specification;


public interface Specification<T> {
    boolean specify(T t);
}
