package com.employeeservice.service;

import com.employeeservice.model.Employee;

public interface EmployeeService  {

    void addEmployee(Employee employee);

    Employee getEmployee(int id);
}
