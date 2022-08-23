package com.example.ems.service;

import com.example.ems.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int empId);
    void deleteEmployeeById(int empId);
    List<Employee> getEmployeeByManager(String empManager);
}
