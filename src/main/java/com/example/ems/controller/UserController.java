package com.example.ems.controller;

import com.example.ems.model.User;
import com.example.ems.service.EmployeeServiceImpl;
import com.example.ems.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping("/")
    public String loginPage(){
        return "Login Page";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        if(user.getUsername()!=null && user.getPassword()!=null && !user.getPassword().isEmpty()){
            userServiceImpl.saveUser(user);
            return "registration successfull";
        }
        return "registration unsuccessfull try again!!";
    }

    @GetMapping("/getUser")// not working
    public User getUser(@RequestBody User user) {

        User output=userServiceImpl.getUserByUsername(user.getUsername());
        if(output==null){
            return null;
        }
        if(!user.getPassword().equals(user.getPassword())){
            return null;
        }
        return output;
    }

}