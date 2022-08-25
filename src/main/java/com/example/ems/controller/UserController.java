package com.example.ems.controller;

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

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")
    public String loginPage(){
        return "Login Page";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        if(user.getUsername()!=null && user.getPassword()!=null && !user.getPassword().isEmpty()){
            User user1=new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userServiceImpl.saveUser(user1);
            return "registration successfull";
        }
        return "registration unsuccessfull try again!!";
    }

    @GetMapping("/getUser")
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