package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto) throws ResourceNotFoundException;
    Employee getEmployeeById(int id) throws ResourceNotFoundException;

    void deleteEmployeeById(int id) throws ResourceNotFoundException;

    Page<Employee> getEmployeeByManager(String manager, Pageable pageable);

    Employee updateEmployeeById(int id, EmployeeDto employeeDto) throws ResourceNotFoundException;

    Page<Employee> getEmployees(int pageNo, int pageSize, String sortField, String sortDirection, String manager, Integer id, String fStr, String lStr, String department);
}
