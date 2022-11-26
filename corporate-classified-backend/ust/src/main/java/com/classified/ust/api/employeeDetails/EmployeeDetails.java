package com.classified.ust.api.employeeDetails;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.offer.Offer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "classified_employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeDetailsId;
    @Column(nullable = false)
    private String employeeDetailsName;

    private int employeeDetailsPointsGained;
    private String employeeDetailsMobileNumber;
    private boolean employeeDetailsActive;
    private String employeeDetailsAddress;
    @Column(nullable = false)
    private LocalDateTime employeeDetailsCreatedDate;
    private LocalDateTime employeeDetailsModifiedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    @Column(name = "offer_id")
    private Set<Offer> offerSet;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeDetails")
    @JoinColumn(name = "employee_id")
    private Employee employeeId;
}
