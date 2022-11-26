package com.classified.ust.api.jwt;

import com.classified.ust.api.employee.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; //24 hrs

    @Value("${ust.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(Employee employee) {
        return Jwts.builder().setSubject(employee.getEmployeeId() + "," + employee.getEmployeeEmail())
                .setIssuer("ust").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}