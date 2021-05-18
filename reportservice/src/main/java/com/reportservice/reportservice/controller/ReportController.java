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

@RestController
public class ReportController {

    @Autowired
    private EmployeesServiceClient employeesServiceClient;

    static final String PREFIX = "/report";

    static final int MLS_PER_DAY = 1000 * 60 * 60 * 24;

    @GetMapping(PREFIX + "/{id}")
    public ResponseEntity getWorkDuration(@PathVariable int id) {
        Employee employee = employeesServiceClient.getEmployee(id);
        if (employee == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        Date endDate = employee.getDismissDate();
        if (endDate == null) {
            endDate = new Date();
        }
        return new ResponseEntity((endDate.getTime() - employee.getStartDate().getTime()) / MLS_PER_DAY, HttpStatus.OK);
    }
}
