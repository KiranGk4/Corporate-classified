package com.classified.ust.api.employeeDetails;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.employee.EmployeeService;
import com.classified.ust.api.employee.EmployeeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
@RestController
@Slf4j
public class EmployeeDetailsController {
    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @Autowired
    EmployeeService employeeService;

   /* @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable Long id)
    {
        log.info("response of employee");
        try
        {
            EmployeeDetails employeeDetails = employeeDetailsService.getEmployeeById(id);
            return new ResponseEntity<EmployeeDetails>(employeeDetails, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/employee-details/")
    public ResponseEntity<EmployeeDetails> saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails)
    {
        try
        {
            EmployeeDetails employeeDetails1 = employeeDetailsService.saveEmployeeDetails(employeeDetails);
            //Employee employee1 = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(employeeDetails1, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }
}
