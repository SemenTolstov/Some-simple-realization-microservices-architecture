package com.reportservice.reportservice.service;


import com.reportservice.reportservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@FeignClient(name = "employeesClient", url = "http://localhost:8080", path = "/employees")
public interface EmployeesServiceClient {

    @GetMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    List<Employee> getAll();

    @GetMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    Employee saveEmployee(@RequestBody Employee employee);

    @GetMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    Employee get(@PathVariable("id") int id);
}
