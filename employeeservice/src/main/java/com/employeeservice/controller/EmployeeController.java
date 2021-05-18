package com.employeeservice.controller;

import com.employeeservice.model.Employee;
import com.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    static final String PREFIX = "/employees";
    static final String PATH_WITH_ID = PREFIX + "/{id}";

    @PostMapping(PREFIX)
    public void addEmployee(Employee employee){

        employeeService.addEmployee(employee);
    }

    @GetMapping(PATH_WITH_ID)
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
}
