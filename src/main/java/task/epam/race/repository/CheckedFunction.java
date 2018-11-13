package task.epam.race.repository;

public interface CheckedFunction<T, R, E extends Exception> {

    R apply(T t) throws E;
}
