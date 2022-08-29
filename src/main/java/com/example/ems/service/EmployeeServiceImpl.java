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
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setManager(employeeDto.getManager());
        employeeRepo.save(employee);
        return employee;
    }
    @Override
    public List<Employee> getEmployeeByManager(String manager) {
        return employeeRepo.findByManager(manager);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployeeById(int id, EmployeeDto employeeDto) {
        Employee employee= employeeRepo.findById(id).orElse(null);
        if(employee==null){
            return null;
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setManager(employeeDto.getManager());
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepo.deleteById(id);
    }

}
