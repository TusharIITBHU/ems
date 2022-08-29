package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/addEmployee")
    public List<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
        employeeServiceImpl.saveEmployee(employeeDto);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employeeDto.getManager());
        return list;
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(Authentication authentication){
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(authentication.getName());
        return list;
    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        return employee;
    }

    @PutMapping ("/updateEmployee/{id}")
    public List<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody EmployeeDto employeeDto){
        String oldmanager=employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.updateEmployeeById(id,employeeDto);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(oldmanager);
        return list;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable("id") int id){
        String oldmanager=employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.deleteEmployeeById(id);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(oldmanager);
        return list;
    }

}