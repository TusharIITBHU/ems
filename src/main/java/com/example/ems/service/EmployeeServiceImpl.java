package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();
        employee.setEmpId(employeeDto.getEmpId());
        employee.setEmpFirstName(employeeDto.getEmpFirstName());
        employee.setEmpLastName(employeeDto.getEmpLastName());
        employee.setEmpDepartment(employeeDto.getEmpDepartment());
        employee.setEmpManager(employeeDto.getEmpManager());
        employeeRepo.save(employee);
    }
    @Override
    public List<Employee> getEmployeeByManager(String empManager) {
        return employeeRepo.findByEmpManager(empManager);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(null);
    }

    @Override
    public Employee updateEmployeeById(int empId, EmployeeDto employeeDto) {
        Employee employee= employeeRepo.findById(empId).orElse(null);
        if(employee==null){
            return null;
        }
        employee.setEmpFirstName(employeeDto.getEmpFirstName());
        employee.setEmpLastName(employeeDto.getEmpLastName());
        employee.setEmpDepartment(employeeDto.getEmpDepartment());
        employee.setEmpManager(employeeDto.getEmpManager());
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int empId) {
        employeeRepo.deleteById(empId);
    }

}
