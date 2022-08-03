package com.example.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    EmployeesRepo employeesRepo;

    //create
    @GetMapping("/newemployeeform")
    public String viewemployeeform(){
        return "newemployee.jsp";
    }


    @PostMapping("/addemployee")
    public String addemployee(@ModelAttribute Employees employee,Model model){
        Employees emp=new Employees();
        emp.setEmpname(employee.getEmpname());
        emp.setEmpdepartment(employee.getEmpdepartment());
        emp.setEmpmanager(employee.getEmpmanager());
        employeesRepo.save(emp);
        List<Employees> list=employeesRepo.findByEmpmanager(emp.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }

    //postman
    @GetMapping("/addemployee")
    @ResponseBody
    public List<Employees> viewprofile(){
        List<Employees> list=employeesRepo.findAll();
        return list;
    }

    //update
    @GetMapping("/updateemployeeform")
    public String viewupdateemployeeform(@RequestParam int empid, Model model){
        Employees emp=employeesRepo.findById(empid).orElse(null);
        model.addAttribute("emp",emp);
        return "updateemployeeform.jsp";
    }

    @PostMapping("/updateemployee")
    public String updateemployee(@RequestParam int empid,Model model, @ModelAttribute Employees employee){
        Employees emp= employeesRepo.findById(empid).orElse(null);
        emp.setEmpname(employee.getEmpname());
        emp.setEmpdepartment(employee.getEmpdepartment());
        emp.setEmpmanager(employee.getEmpmanager());
        employeesRepo.save(emp);
        List<Employees> list=employeesRepo.findByEmpmanager(employee.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }


    //Delete
    @GetMapping("/deleteemployee")
    public String deleteemployee(@RequestParam int empid, Model model){
        Employees emp=employeesRepo.findById(empid).orElse(null);
        employeesRepo.deleteById(empid);
        List<Employees> list=employeesRepo.findByEmpmanager(emp.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }


}
