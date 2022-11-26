package com.classified.ust.api.employee;

import com.classified.ust.api.employee.EmployeeRepository;
import com.classified.ust.api.employeeDetails.EmployeeDetails;
import com.classified.ust.api.employeeDetails.EmployeeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeDetailsService employeeDetailsService;
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


    public Employee saveEmployee(Employee employee) {
       /* employeeDetails.setEmployeeDetailsCreatedDate(LocalDateTime.now());
        employeeDetails.setEmployeeDetailsModifiedDate(employeeDetails.getEmployeeDetailsCreatedDate());
        employeeDetails.setEmployeeDetailsActive(true);*/
        employee.setEmployeeCreatedDate(LocalDateTime.now());
        employee.setEmployeeModifiedDate(employee.getEmployeeCreatedDate());
        employee.setEmployeeActive(true);
        //employeeDetailsService.saveEmpoyee(employeeDetails);
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeByEmail(String email)
    {
        return employeeRepository.findByEmployeeEmail(email).get();
    }
}
