package com.example.ems.services;

import com.example.ems.models.Employees;
import com.example.ems.repositories.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    EmployeesRepo employeesRepo;

    @Override
    public void saveEmployee(Employees employee) {
        employeesRepo.save(employee);
    }

    @Override
    public Employees getEmployeeById(int empid) {
        return employeesRepo.findById(empid).get();
    }

    @Override
    public List<Employees> getEmployee(String empmanager) {
        return employeesRepo.findByEmpmanager(empmanager);
    }

    @Override
    public void deleteEmployeeById(int empid) {
        employeesRepo.deleteById(empid);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }


}
