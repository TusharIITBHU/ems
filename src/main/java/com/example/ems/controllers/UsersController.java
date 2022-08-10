package com.example.ems.controllers;

import com.example.ems.models.Users;
import com.example.ems.services.EmployeesServiceImpl;
import com.example.ems.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UsersServiceImpl usersServiceImpl;
    @Autowired
    EmployeesServiceImpl employeesServiceImpl;

    @RequestMapping("/")
    public String loginpage(){
        return "login page";
    }

    @PostMapping("/newuser")
    public String newuser(@RequestBody Users user){
        if(user.getUsername()!=null && user.getPassword()!=null && !user.getPassword().isEmpty()){
            usersServiceImpl.saveUser(user);
            return "registration successfull";
        }
        return "registration unsuccessfull try again!!";
    }

    @PostMapping("/profilepage")
    public Users profilepage(@RequestBody Users users) {

        Users user=usersServiceImpl.getUserByUsername(users.getUsername());
        if(user==null){
            return null;
        }
        if(!user.getPassword().equals(users.getPassword())){
            return null;
        }
        return user;
    }

}