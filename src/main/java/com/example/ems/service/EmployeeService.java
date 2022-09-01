package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto) throws ResourceNotFoundException;
    Employee getEmployeeById(int id) throws ResourceNotFoundException;
    void deleteEmployeeById(int id) throws ResourceNotFoundException;
    List<Employee> getEmployeeByManager(String manager);
    Employee updateEmployeeById(int id,EmployeeDto employeeDto) throws ResourceNotFoundException;
}
