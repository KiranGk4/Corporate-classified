package com.classified.ust.api.employeeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRespository extends JpaRepository<EmployeeDetails, Long> {
}
