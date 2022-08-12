package com.example.ems.repositories;

import com.example.ems.models.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeesRepo extends MongoRepository<Employees,Integer> {
    public List<Employees> findByEmpmanager(String empmanager);
}
