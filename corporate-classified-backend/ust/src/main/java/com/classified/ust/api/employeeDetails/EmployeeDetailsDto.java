package com.classified.ust.api.employeeDetails;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.employee.EmployeeDto;
import com.classified.ust.api.offer.Offer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class EmployeeDetailsDto {
    //private long employeeDetailsId;
    private String employeeDetailsName;

    private int employeeDetailsPointsGained;
    private String employeeDetailsMobileNumber;
    private String employeeDetailsAddress;

    //private EmployeeDto employee;
}
