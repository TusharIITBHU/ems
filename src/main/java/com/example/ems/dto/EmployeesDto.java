package com.example.ems.dto;

public class EmployeesDto {

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
        return "EmployeesDto{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empdepartment='" + empdepartment + '\'' +
                ", empmanager='" + empmanager + '\'' +
                '}';
    }
}
