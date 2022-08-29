package com.example.ems.repository;

import com.example.ems.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepo extends MongoRepository<Employee,Integer> {
    public List<Employee> findByManager(String manager);
}
