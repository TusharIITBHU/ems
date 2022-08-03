package com.example.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    EmployeesRepo employeesRepo;

    @RequestMapping("/")
    public String loginpage(){
        return "loginpage.jsp";
    }

    @PostMapping("/newuser")
    public String newuser(@ModelAttribute Users user){
        if(user.getUsername()!=null && user.getPassword()!=null){
            usersRepo.save(user);
        }
        return "loginpage.jsp";
    }

    @PostMapping("/profilepage")
    public String profilepage(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        Users user=usersRepo.findById(username).orElse(null);
        if(user==null){
            return "loginpage.jsp";
        }
        if(user.getPassword().equals(password)==false){
            return "loginpage.jsp";
        }
        List<Employees> list=employeesRepo.findByEmpmanager(username);
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }

    //postman
    @GetMapping("/profilepage")
    @ResponseBody
    public List<Employees> viewprofile(){
        List<Employees> list=employeesRepo.findAll();
        return list;
    }



}
