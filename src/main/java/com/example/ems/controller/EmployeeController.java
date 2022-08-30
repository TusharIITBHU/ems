package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.OutputDto;
import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/addEmployee")
    public OutputDto addEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee=employeeServiceImpl.saveEmployee(employeeDto);
        return new OutputDto(employee,HttpStatus.CREATED);
    }

    @GetMapping("/getEmployees")
    public OutputDto getEmployees(Authentication authentication){
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(authentication.getName());
        return new OutputDto(list,HttpStatus.OK);
    }
    @GetMapping("/getEmployee/{id}")
    public OutputDto getEmployeeById(@PathVariable("id") int id){
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        return new OutputDto(employee,HttpStatus.OK);
    }

    @PutMapping ("/updateEmployee/{id}")
    public OutputDto updateEmployee(@PathVariable("id") int id,@RequestBody EmployeeDto employeeDto){
        String oldmanager=employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.updateEmployeeById(id,employeeDto);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(oldmanager);
        return new OutputDto(list,HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public OutputDto deleteEmployee(@PathVariable("id") int id){
        String oldmanager=employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.deleteEmployeeById(id);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(oldmanager);
        return new OutputDto(list,HttpStatus.OK);
    }

}