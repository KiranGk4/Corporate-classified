package com.classified.ust.api.employee;

import com.classified.ust.api.employee.EmployeeService;
import com.classified.ust.api.employeeDetails.EmployeeDetails;
import com.classified.ust.api.employeeDetails.EmployeeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

   @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id)
    {
        log.info("response of employee");
        try
        {
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employee/")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        log.info("response of employee");
        try
        {
            Employee employee1 = employeeService.saveEmployee(employee);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee-email/{email}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String email)
    {
        log.info("response of employee");
        try
        {
            Employee employee = employeeService.getEmployeeByEmail(email);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
