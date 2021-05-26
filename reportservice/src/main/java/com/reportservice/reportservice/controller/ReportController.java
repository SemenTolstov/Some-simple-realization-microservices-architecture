package com.reportservice.reportservice.controller;

import com.reportservice.reportservice.model.Employee;
import com.reportservice.reportservice.service.EmployeesServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private EmployeesServiceClient employeesServiceClient;

    static final String PREFIX = "/report";

    static final int MLS_PER_DAY = 1000 * 60 * 60 * 24;

    @GetMapping(PREFIX + "/{id}")
    public ResponseEntity getWorkDuration(@PathVariable int id) {
        Employee employee = employeesServiceClient.get(id);
        if (employee == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        Date endDate = employee.getDismissDate();
        if (endDate == null) {
            endDate = new Date();
        }
        return new ResponseEntity((endDate.getTime() - employee.getStartDate().getTime()) / MLS_PER_DAY, HttpStatus.OK);
    }

    @GetMapping(PREFIX)
    public ResponseEntity getAverageWorkDuration(){
        List<Employee> employees = employeesServiceClient.getAll();
        if(employees.size() == 0) return new ResponseEntity(HttpStatus.NOT_FOUND);
        int workDaysCount = 0;
        Date now = new Date();
        for(int i = 0; i < employees.size(); i++){
            Date endDate = employees.get(i).getDismissDate();
            if(endDate == null) endDate = now;
            workDaysCount += (endDate.getTime() - employees.get(i).getStartDate().getTime())/MLS_PER_DAY;
        }
        return new ResponseEntity(workDaysCount/employees.size(), HttpStatus.OK);
    }
}
