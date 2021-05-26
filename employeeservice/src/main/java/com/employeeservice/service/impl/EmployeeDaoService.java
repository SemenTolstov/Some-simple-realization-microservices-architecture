package com.employeeservice.service.impl;

import com.employeeservice.model.Employee;
import com.employeeservice.service.Dao;
import com.employeeservice.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeDaoService implements Dao<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> get(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> allEmployees = new ArrayList<>();
        for (Employee employee : employeeIterable) {
            allEmployees.add(employee);
        }
        return allEmployees;
    }

    @Override
    public int save(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getId();
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (!optionalEmployee.isPresent()) return optionalEmployee;
        Employee toUpdate = optionalEmployee.get();
        return Optional.of(employeeRepository.save(toUpdate));
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }


}
