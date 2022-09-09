package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.OutputDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/addEmployee")
    public OutputDto<Employee> addEmployee(@RequestBody EmployeeDto employeeDto) throws ResourceNotFoundException {
        Employee employee = employeeServiceImpl.saveEmployee(employeeDto);
        return new OutputDto<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee/{id}")
    public OutputDto<Employee> getEmployeeById(@PathVariable("id") int id) throws ResourceNotFoundException {
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        return new OutputDto<>(employee, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")
    public OutputDto<Page<Employee>> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) throws ResourceNotFoundException {
        String oldManager = employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.updateEmployeeById(id, employeeDto);
        Page<Employee> page = employeeServiceImpl.getEmployeeByManager(oldManager, null);
        return new OutputDto<>(page, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public OutputDto<Page<Employee>> deleteEmployee(@PathVariable("id") int id) throws ResourceNotFoundException {
        String oldManager = employeeServiceImpl.getEmployeeById(id).getManager();
        employeeServiceImpl.deleteEmployeeById(id);
        Page<Employee> page = employeeServiceImpl.getEmployeeByManager(oldManager, null);
        return new OutputDto<>(page, HttpStatus.OK);
    }

    @GetMapping("/getEmployees")
    public OutputDto<Page<Employee>> getEmployeesByPaginationAndSorting(@RequestParam(defaultValue = "1") int pageNumber,
                                                                        @RequestParam(defaultValue = "2") int pageSize,
                                                                        @RequestParam(defaultValue = "id") String sortField,
                                                                        @RequestParam(defaultValue = "ASC") String sortDirection,
                                                                        Authentication authentication,
                                                                        @RequestParam(defaultValue = "0") Integer id,
                                                                        @RequestParam(defaultValue = "") String fStr,
                                                                        @RequestParam(defaultValue = "") String lStr,
                                                                        @RequestParam(defaultValue = "") String department) {
        Page<Employee> page = employeeServiceImpl.getEmployees(pageNumber, pageSize, sortField, sortDirection, authentication.getName(), id, fStr, lStr, department);
        return new OutputDto<>(page, HttpStatus.OK);
    }

}