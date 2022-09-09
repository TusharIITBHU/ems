package com.example.ems.repository;

import com.example.ems.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,Integer> {
    public Page<Employee> findByManager(String manager, Pageable pageable);
}
