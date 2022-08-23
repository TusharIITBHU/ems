package com.example.ems.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Employee {
    @MongoId
    private int empId;
    private String empName;
    private String empDepartment;
    private String empManager;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }
    public String getEmpManager() {
        return empManager;
    }

    public void setEmpManager(String empManager) {
        this.empManager = empManager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", empManager='" + empManager + '\'' +
                '}';
    }
}
