package com.employeeservice.controller;

import com.employeeservice.model.Employee;
import com.employeeservice.service.impl.EmployeeDaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeDaoService employeeDaoService;

    static final String PREFIX = "/employees";
    static final String PATH_WITH_ID = PREFIX + "/{id}";

    @GetMapping(PREFIX)
    public List<Employee> list() {

        return employeeDaoService.getAll();
    }

    @PostMapping(PREFIX)
    public void addEmployee(Employee employee){
        employeeDaoService.save(employee);
    }

    @GetMapping(PATH_WITH_ID)
    public ResponseEntity getEmployee(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeDaoService.get(id);
        if(!optionalEmployee.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return new ResponseEntity(optionalEmployee.get(),HttpStatus.OK);

    }
}
