package com.example.ems.controllers;

import com.example.ems.dto.EmployeesDto;
import com.example.ems.models.Employees;
import com.example.ems.models.Users;
import com.example.ems.services.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    EmployeesServiceImpl employeesServiceImpl;

    //create
    // nothing but forms/pages
//    @GetMapping("/newemployeeform")
//    public String viewemployeeform(){
//        return "newemployee.jsp";
//    }
    @PostMapping("/addemployee")
    public List<Employees> addemployee(@RequestBody EmployeesDto employeesDto){
        Employees emp=new Employees();
        emp.setEmpid(employeesDto.getEmpid());
        emp.setEmpname(employeesDto.getEmpname());
        emp.setEmpdepartment(employeesDto.getEmpdepartment());
        emp.setEmpmanager(employeesDto.getEmpmanager());
        employeesServiceImpl.saveEmployee(emp);
        List<Employees> list=employeesServiceImpl.getEmployee(emp.getEmpmanager());
        return list;
    }

    @GetMapping("/getemployees")
    public List<Employees> getemployees(@RequestBody Users user){
        List<Employees> list=employeesServiceImpl.getEmployee(user.getUsername());
        return list;
    }

    //update
    // nothing but forms/pages
//    @GetMapping("/updateemployeeform")
//    public String viewupdateemployeeform(@RequestParam int empid, Model model){
//        Employees emp= employeesServiceImpl.getEmployeeById(empid);
//        model.addAttribute("emp",emp);
//        return "updateemployeeform.jsp";
//    }

    @PutMapping ("/updateemployee")
    public List<Employees> updateemployee(@RequestBody EmployeesDto employeesDto){
        Employees emp= employeesServiceImpl.getEmployeeById(employeesDto.getEmpid());
        emp.setEmpname(employeesDto.getEmpname());
        emp.setEmpdepartment(employeesDto.getEmpdepartment());
        emp.setEmpmanager(employeesDto.getEmpmanager());
        employeesServiceImpl.saveEmployee(emp);
        List<Employees> list=employeesServiceImpl.getEmployee(employeesDto.getEmpmanager());
        return list;
    }


    @DeleteMapping("/deleteemployee")
    public Employees deleteemployee(@RequestBody EmployeesDto employeesDto){
        Employees emp=employeesServiceImpl.getEmployeeById(employeesDto.getEmpid());
        employeesServiceImpl.deleteEmployeeById(employeesDto.getEmpid());
        return emp;
    }

}