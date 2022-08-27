package com.example.ems.controller;

import com.example.ems.dto.UserDto;
import com.example.ems.model.User;
import com.example.ems.service.EmployeeServiceImpl;
import com.example.ems.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/login")
    public String loginPage(){
        return "Login Page";
    }

    @PostMapping("/signup")
    public String addUser(@RequestBody UserDto userDto){
        if(!userDto.getUsername().isEmpty() && !userDto.getPassword().isEmpty()){
            userServiceImpl.saveUser(userDto);
            return "registration successfull";
        }
        else {
            return "registration unsuccessfull try again!!";
        }
    }

    @GetMapping("/getUser")
    public User getUser(@RequestBody UserDto userDto) {

        User user=userServiceImpl.getUserByUsername(userDto.getUsername());
        if(user==null){
            return null;
        }
        if(!user.getPassword().equals(userDto.getPassword())){
            return null;
        }
        return user;
    }

}