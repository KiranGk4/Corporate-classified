package com.classified.ust;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.employee.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class EmployeeRepositoryTest {

   // @Autowired
   // EmployeeRepository repo;

   // @Test //going to perform testcase for the method
    //public void testCreateUser(){
       // PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
       //// String rawPassword="namitha";
        //String encodedPassword= passwordEncoder.encode(rawPassword);

        //User newUser=new User("aruns12mail@gmail.com",encodedPassword);
        ///Employee newUser = new Employee("namitha@gmail.com",encodedPassword, LocalDateTime.now());

        //Employee savedUser= repo.save(newUser);

       // assert(savedUser).getEmployeeId()>0;
       // assert(savedUser.getEmployeeEmail()).endsWith(".com");
   // }
//}

