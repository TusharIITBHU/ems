package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.dto.ErrorDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) throws ResourceNotFoundException {

        if (employeeRepo.existsById(employeeDto.getId())) {
            throw new ResourceNotFoundException(new ErrorDto("EMPLOYEE_EXIST", "Employee with this id already exist"));
        }
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getDepartment(), employeeDto.getManager());
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public Page<Employee> getEmployeeByManager(String manager, Pageable pageable) {
        return employeeRepo.findByManager(manager, null);
    }

    @Override
    public Employee getEmployeeById(int id) throws ResourceNotFoundException {
        Employee employee=employeeRepo.findById(id).orElse(null);
        if(employee==null){
            throw new ResourceNotFoundException(new ErrorDto("EMPLOYEE_NOT_FOUND","Employee with this id does not exist"));
        }
        return employee;
    }

    @Override
    public Employee updateEmployeeById(int id, EmployeeDto employeeDto) throws ResourceNotFoundException {
        Employee employee= employeeRepo.findById(id).orElse(null);
        if(employee==null){
            throw new ResourceNotFoundException(new ErrorDto("EMPLOYEE_NOT_FOUND","Employee with this id does not exist, hence cannot update"));
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setManager(employeeDto.getManager());
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) throws ResourceNotFoundException {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if (employee == null) {
            throw new ResourceNotFoundException(new ErrorDto("EMPLOYEE_NOT_FOUND", "Employee with this id does not exist, hence cannot delete"));
        }
        employeeRepo.deleteById(id);
    }

    @Override
    public Page<Employee> getEmployees(int pageNumber, int pageSize, String sortField, String sortDirection, String manager, Integer id, String fStr, String lStr, String department) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Query query = new Query();
        if (id != 0) {
            query.addCriteria(Criteria.where("id").is(id));
        }
        if (fStr != "") {
            query.addCriteria(Criteria.where("firstName").regex(fStr));
        }
        if (lStr != "") {
            query.addCriteria(Criteria.where("lastName").regex(lStr));
        }
        if (department != "") {
            query.addCriteria(Criteria.where("department").regex(department));
        }
        query.addCriteria(Criteria.where("manager").is(manager));
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        query.with(pageable);

        Page<Employee> page = PageableExecutionUtils.getPage(mongoTemplate.find(query, Employee.class), pageable, () -> mongoTemplate.count(query.skip(0).limit(0), Employee.class));
        return page;
    }
}
