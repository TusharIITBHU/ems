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
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employeeDto.getEmpManager());
        return list;
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(Authentication authentication){
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(authentication.getName());
        return list;
    }
    @GetMapping("/getemployee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int empId){
        Employee employee = employeeServiceImpl.getEmployeeById(empId);
        return employee;
    }

    @PutMapping ("/updateEmployee/{empId}")
    public List<Employee> updateEmployee(@PathVariable("empId") int empId,@RequestBody EmployeeDto employeeDto){
        Employee employee= employeeServiceImpl.updateEmployeeById(empId,employeeDto);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employee.getEmpManager());
        return list;
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public List<Employee> deleteEmployee(@PathVariable("empId") int empId){
        Employee employee=employeeServiceImpl.getEmployeeById(empId);
        employeeServiceImpl.deleteEmployeeById(empId);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employee.getEmpManager());
        return list;
    }

}