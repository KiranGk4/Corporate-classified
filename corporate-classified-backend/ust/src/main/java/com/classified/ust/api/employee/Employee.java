package com.classified.ust.api.employee;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.employeeDetails.EmployeeDetails;
import com.classified.ust.api.offer.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "classified_employee")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    public Employee() {
    }

    public Employee(String employeeEmail, String employeePassword, LocalDateTime employeeCreatedDate) {
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;
        this.employeeCreatedDate = employeeCreatedDate;
    }

    @Email
    @Column(nullable = false, unique = true)
    private String employeeEmail;
    @Column(nullable = false)
    private String employeePassword;

    private boolean employeeActive;

    @Column(nullable = false)
    private LocalDateTime employeeCreatedDate;
    private LocalDateTime employeeModifiedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_details_id")
    private EmployeeDetails employeeDetails;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeEngage")
    @Column(name = "employee_engage_offer_id")
    private Set<Offer> offerSet;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return employeePassword;
    }

    @Override
    public String getUsername() {
        return employeeEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
