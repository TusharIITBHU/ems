package com.example.ems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Integer> {
    public List<Employees> findByEmpmanager(String empmanager);
}
