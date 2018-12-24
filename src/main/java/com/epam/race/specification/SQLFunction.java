package com.epam.race.specification;

import java.sql.SQLException;


@FunctionalInterface
public interface SQLFunction<T,K, E extends SQLException> {
    K apply(T t) throws E;
}
