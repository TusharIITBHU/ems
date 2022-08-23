package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.model.Employee;
import com.example.ems.model.User;
import com.example.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/addEmployee")
    public List<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
        Employee emp=new Employee();
        emp.setEmpId(employeeDto.getEmpId());
        emp.setEmpName(employeeDto.getEmpName());
        emp.setEmpDepartment(employeeDto.getEmpDepartment());
        emp.setEmpManager(employeeDto.getEmpManager());
        employeeServiceImpl.saveEmployee(emp);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employeeDto.getEmpManager());
        return list;
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployee(@RequestBody User user){
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(user.getUsername());
        return list;
    }

    @PutMapping ("/updateEmployee")
    public List<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto){
        Employee emp= employeeServiceImpl.getEmployeeById(employeeDto.getEmpId());
        emp.setEmpName(employeeDto.getEmpName());
        emp.setEmpDepartment(employeeDto.getEmpDepartment());
        emp.setEmpManager(employeeDto.getEmpManager());
        employeeServiceImpl.saveEmployee(emp);
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employeeDto.getEmpManager());
        return list;
    }


    @DeleteMapping("/deleteEmployee")
    public List<Employee> deleteEmployee(@RequestBody EmployeeDto employeeDto){
        employeeServiceImpl.deleteEmployeeById(employeeDto.getEmpId());
        List<Employee> list=employeeServiceImpl.getEmployeeByManager(employeeDto.getEmpManager());
        return list;
    }

}