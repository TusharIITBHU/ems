package com.example.ems.controllers;

import com.example.ems.models.Employees;
import com.example.ems.models.Users;
import com.example.ems.services.EmployeesServiceImpl;
import com.example.ems.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersServiceImpl usersServiceImpl;
    @Autowired
    EmployeesServiceImpl employeesServiceImpl;
    @RequestMapping("/")
    public String loginpage(){
        return "loginpage.jsp";
    }

    @PostMapping("/newuser")
    public String newuser(@ModelAttribute Users user){
        if(user.getUsername()!=null && user.getPassword()!=null){
            usersServiceImpl.saveUser(user);
        }
        return "loginpage.jsp";
    }

    @PostMapping("/profilepage")
    public String profilepage(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        Users user=usersServiceImpl.getUserByUsername(username);
        if(user==null){
            return "loginpage.jsp";
        }
        if(user.getPassword().equals(password)==false){
            return "loginpage.jsp";
        }
        List<Employees> list=employeesServiceImpl.getEmployee(username);
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }

    //postman
    @GetMapping("/profilepage")
    @ResponseBody
    public List<Employees> viewprofile(){
        List<Employees> list=employeesServiceImpl.getAllEmployees();
        return list;
    }
}
