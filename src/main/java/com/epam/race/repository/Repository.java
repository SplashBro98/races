package com.epam.race.repository;

import com.epam.race.specification.SQLSpecification;

import java.util.List;

public interface Repository<T> {

    void add(T t) throws RepositoryException;
    void remove(T t) throws RepositoryException;
    void update(SQLSpecification specification) throws RepositoryException;

    List<T> query(SQLSpecification specification) throws RepositoryException;
}
