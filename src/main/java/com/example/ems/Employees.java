package com.example.ems;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    private String empname;
    private String empdepartment;
    private String empmanager;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpdepartment() {
        return empdepartment;
    }

    public void setEmpdepartment(String empdepartment) {
        this.empdepartment = empdepartment;
    }
    public String getEmpmanager() {
        return empmanager;
    }

    public void setEmpmanager(String empmanager) {
        this.empmanager = empmanager;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empdepartment='" + empdepartment + '\'' +
                ", empmanager='" + empmanager + '\'' +
                '}';
    }
}
