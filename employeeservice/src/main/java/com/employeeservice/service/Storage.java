package com.employeeservice.service;

import com.employeeservice.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    public static List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    public static int addEmployee(Employee employee) {
        int id = currentId++;
        employee.setId(id);
        employees.put(id, employee);
        return id;
    }

    public static Employee getEmployee(int employeeId) {
        if (employees.containsKey(employeeId)) return employees.get(employeeId);
        return null;
    }

    public static Employee deleteEmployee(int employeeId) {
        if (employees.containsKey(employeeId)) return employees.remove(employeeId);
        return null;
    }
}
