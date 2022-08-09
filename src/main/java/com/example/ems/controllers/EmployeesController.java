package com.example.ems.controllers;

import com.example.ems.dto.EmployeesDto;
import com.example.ems.models.Employees;
import com.example.ems.services.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    EmployeesServiceImpl employeesServiceImpl;

    //create
    @GetMapping("/newemployeeform")
    public String viewemployeeform(){
        return "newemployee.jsp";
    }


    @PostMapping("/addemployee")
    public String addemployee(@ModelAttribute EmployeesDto employeesDto,Model model){
        Employees emp=new Employees();
        emp.setEmpname(employeesDto.getEmpname());
        emp.setEmpdepartment(employeesDto.getEmpdepartment());
        emp.setEmpmanager(employeesDto.getEmpmanager());
        employeesServiceImpl.saveEmployee(emp);
        List<Employees> list=employeesServiceImpl.getEmployee(emp.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }


    @GetMapping("/addemployee")
    @ResponseBody
    public List<Employees> viewprofile(){
        return employeesServiceImpl.getAllEmployees();
    }

    //update
    @GetMapping("/updateemployeeform")
    public String viewupdateemployeeform(@RequestParam int empid, Model model){
        Employees emp= employeesServiceImpl.getEmployeeById(empid);
        model.addAttribute("emp",emp);
        return "updateemployeeform.jsp";
    }

    @PostMapping("/updateemployee")
    public String updateemployee(@RequestParam int empid,Model model, @ModelAttribute EmployeesDto employeesDto){
        Employees emp= employeesServiceImpl.getEmployeeById(empid);
        emp.setEmpname(employeesDto.getEmpname());
        emp.setEmpdepartment(employeesDto.getEmpdepartment());
        emp.setEmpmanager(employeesDto.getEmpmanager());
        employeesServiceImpl.saveEmployee(emp);
        List<Employees> list=employeesServiceImpl.getEmployee(employeesDto.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }

    //Delete
    @GetMapping("/deleteemployee")
    public String deleteemployee(@RequestParam int empid, Model model){
        Employees emp=employeesServiceImpl.getEmployeeById(empid);
        employeesServiceImpl.deleteEmployeeById(empid);
        List<Employees> list=employeesServiceImpl.getEmployee(emp.getEmpmanager());
        model.addAttribute("list",list);
        return "profilepage.jsp";
    }

}
