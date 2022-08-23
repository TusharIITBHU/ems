package com.example.ems.service;

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
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).get();
    }

    @Override
    public List<Employee> getEmployeeByManager(String empManager) {
        return employeeRepo.findByEmpManager(empManager);
    }

    @Override
    public void deleteEmployeeById(int empId) {
        employeeRepo.deleteById(empId);
    }

}
