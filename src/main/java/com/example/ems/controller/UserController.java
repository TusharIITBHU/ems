package com.example.ems.controller;

import com.example.ems.dto.OutputDto;
import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.service.EmployeeServiceImpl;
import com.example.ems.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/login")
    public OutputDto<Boolean> loginPage(Authentication authentication, @RequestBody UserDto userDto) {

        if (authentication.isAuthenticated() && userServiceImpl.checkUser(userDto)) {

            return new OutputDto(true, HttpStatus.OK);

        }
        return new OutputDto(false, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/logout")
    public void logout(Authentication authentication) {
    }

    @PostMapping("/signup")
    public OutputDto addUser(@RequestBody UserDto userDto) throws ResourceNotFoundException {
        userServiceImpl.saveUser(userDto);
        return new OutputDto(null, HttpStatus.CREATED);
    }

}