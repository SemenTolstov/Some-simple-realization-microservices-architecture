package com.employeeservice.service;

import com.employeeservice.model.Employee;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    int save(T t);

    Optional<T> update(T t);

    void delete(int id);

    void deleteAll();
}

