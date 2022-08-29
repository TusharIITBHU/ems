package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
    List<Employee> getEmployeeByManager(String manager);
    Employee updateEmployeeById(int id,EmployeeDto employeeDto);
}
