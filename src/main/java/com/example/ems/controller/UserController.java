package com.example.ems.controller;

import com.example.ems.dto.OutputDto;
import com.example.ems.dto.UserDto;
import com.example.ems.service.EmployeeServiceImpl;
import com.example.ems.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/login")
    public OutputDto loginPage(Authentication authentication){
        if(authentication.isAuthenticated()){
            return new OutputDto(null,HttpStatus.OK);
        }
        else{
            return new OutputDto(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public OutputDto addUser(@RequestBody UserDto userDto){
        if(!userDto.getUsername().isEmpty() && !userDto.getPassword().isEmpty()){
            userServiceImpl.saveUser(userDto);
            return new OutputDto(userDto,HttpStatus.CREATED);
        }
            return new OutputDto(null,HttpStatus.BAD_REQUEST);
    }

}