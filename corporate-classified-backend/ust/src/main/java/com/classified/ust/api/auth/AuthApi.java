package com.classified.ust.api.auth;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthApi {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * Login response entity.
     *
     * @param authRequest the auth request
     * @return the response entity
     */
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest) {

        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
                            authRequest.getPassword())
            );
            Employee user = (Employee) authentication.getPrincipal();
           // String accessToken = "UST Access Token";
            String accessToken=jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmployeeEmail(), accessToken);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException badCredentialsException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .build();
        }

    }
}
