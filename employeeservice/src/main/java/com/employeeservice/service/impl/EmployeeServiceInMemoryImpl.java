package com.employeeservice.service.impl;

import com.employeeservice.model.Employee;
import com.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceInMemoryImpl implements EmployeeService {

    private final Map<Integer, Employee> persist = new HashMap<>();
    int keyCounter = 1;

    @Override
    public void addEmployee(Employee employee) {
        persist.put(keyCounter, employee);
        keyCounter++;
    }

    @Override
    public Employee getEmployee(int id) {
        return persist.get(id);
    }
}
