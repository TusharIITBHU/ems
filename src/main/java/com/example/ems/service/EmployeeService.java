package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(int empId);
    void deleteEmployeeById(int empId);
    List<Employee> getEmployeeByManager(String empManager);
    Employee updateEmployeeById(int empId,EmployeeDto employeeDto);
}
