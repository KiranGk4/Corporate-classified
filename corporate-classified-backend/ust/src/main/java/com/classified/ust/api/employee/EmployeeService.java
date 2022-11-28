package com.classified.ust.api.employee;

import com.classified.ust.api.employee.EmployeeRepository;
import com.classified.ust.api.employeeDetails.EmployeeDetails;
import com.classified.ust.api.employeeDetails.EmployeeDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    ModelMapper modelMapper;
//    public Employee getEmployeeById(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }


    public Employee saveEmployee(Employee employee) {
       /* employeeDetails.setEmployeeDetailsCreatedDate(LocalDateTime.now());
        employeeDetails.setEmployeeDetailsModifiedDate(employeeDetails.getEmployeeDetailsCreatedDate());
        employeeDetails.setEmployeeDetailsActive(true);*/
        EmployeeDetails employeeDetails = employeeDetailsService.saveEmployeeDetails(employee.getEmployeeDetails());

        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encodedPassword= passwordEncoder.encode(employee.getPassword());
        employee.setEmployeePassword(encodedPassword);

        employee.setEmployeeCreatedDate(LocalDateTime.now());
        employee.setEmployeeModifiedDate(employee.getEmployeeCreatedDate());
        employee.setEmployeeActive(true);
        employee.setEmployeeDetails(employeeDetails);
//        employee.getEmployeeDetails().setEmployeeDetailsActive(true);
//        employee.getEmployeeDetails().setEmployeeDetailsCreatedDate(employee.getEmployeeCreatedDate());
//        employeeDetailsService.saveEmployeeDetails(employee.getEmployeeDetails());

        Employee employee1 = employeeRepository.save(employee);
        //employeeDetailsService.saveEmpoyee(employeeDetails);
        return employee1;//modelMapper.map(employee1, EmployeeDto.class);
    }

    public EmployeeDto getEmployeeByEmail(String email)
    {
        return modelMapper.map(employeeRepository.findByEmployeeEmail(email).get(), EmployeeDto.class);
    }

    public EmployeeDto getEmployeeById(long id){
        return modelMapper.map(employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException()), EmployeeDto.class);
    }

    public EmployeeDto convertToEmployeeDto(Employee employee1) {
        return modelMapper.map(employee1, EmployeeDto.class);
    }
}
