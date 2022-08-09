package com.example.ems.services;

import com.example.ems.models.Employees;

import java.util.List;

public interface EmployeesService {
    void saveEmployee(Employees employee);
    Employees getEmployeeById(int empid);
    void deleteEmployeeById(int empid);
    List<Employees> getEmployee(String empmanager);
    List<Employees> getAllEmployees();
}
