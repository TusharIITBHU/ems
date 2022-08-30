package com.example.ems.controller;

import com.example.ems.dto.OutputDto;
import com.example.ems.dto.UserDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.service.EmployeeServiceImpl;
import com.example.ems.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/login")
    public OutputDto loginPage(Authentication authentication){
        if(authentication.isAuthenticated()){
            return new OutputDto(null,HttpStatus.OK);
        }
            return new OutputDto(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signup")
    public OutputDto addUser(@RequestBody UserDto userDto) throws ResourceNotFoundException {
            userServiceImpl.saveUser(userDto);
            return new OutputDto(userDto,HttpStatus.CREATED);
    }

}