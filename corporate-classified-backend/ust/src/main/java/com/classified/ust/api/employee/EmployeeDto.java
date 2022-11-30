package com.classified.ust.api.employee;

import com.classified.ust.api.employeeDetails.EmployeeDetails;
import com.classified.ust.api.employeeDetails.EmployeeDetailsDto;
import com.classified.ust.api.offer.Offer;
import com.classified.ust.api.offer.OfferDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Data
public class EmployeeDto {
    private long employeeId;
    private String employeeEmail;
    private boolean employeeActive;

    private EmployeeDetailsDto employeeDetails;

    private Set<OfferDto> offerSet;
}
