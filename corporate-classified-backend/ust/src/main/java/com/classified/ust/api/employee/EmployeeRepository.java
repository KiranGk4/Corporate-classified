package com.classified.ust.api.employee;

import com.classified.ust.api.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Optional<Employee> findByEmail(String username);

    Optional<Employee> findByEmployeeEmail(String username);
    //Optional findByEmail(String username);
}
