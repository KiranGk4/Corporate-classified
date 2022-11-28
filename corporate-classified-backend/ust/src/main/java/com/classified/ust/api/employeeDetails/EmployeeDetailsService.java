package com.classified.ust.api.employeeDetails;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.employee.EmployeeRepository;
import com.classified.ust.api.employee.EmployeeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class EmployeeDetailsService {
    @Autowired
    EmployeeDetailsRespository employeeDetailsRespository;
    EmployeeRepository employeeRepository;


    /*public EmployeeDetails getEmployeeById(Long id)
    {
        return employeeDetailsRespository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public EmployeeDetails saveEmployee(Employee employee)
    {
        // boolean validEmail = EmployeeUtil.validateEmail(employee.getEmployeeEmail());
        //boolean validPassword = EmployeeUtil.validatePassword(employee.getEmployeePassword());
        boolean validaAddress = EmployeeUtil.validateAddress(employee.getEmployeeAddress());
        boolean validMobileNumber = EmployeeUtil.validateMobileNumber(employee.getEmployeeMobileNumber());
        boolean validName = EmployeeUtil.validateName(employee.getEmployeeName());
    }*/

    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails)
    {
        employeeDetails.setEmployeeDetailsCreatedDate(LocalDateTime.now());
        employeeDetails.setEmployeeDetailsModifiedDate(employeeDetails.getEmployeeDetailsCreatedDate());
        employeeDetails.setEmployeeDetailsActive(true);
        return employeeDetailsRespository.save(employeeDetails);
    }

    public void saveEmpoyee(EmployeeDetails employeeDetails) {
        employeeDetailsRespository.save(employeeDetails);
    }
}
