package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceImplTest {

    List<Employee> listExpected = Stream.of(new Employee(1, "tushar", "kapadia", "dev", "tush"),
            new Employee(2, "tusharr", "kapadia", "dev", "tush"),
            new Employee(3, "tusharrr", "kapadia", "dev", "tush")).collect(Collectors.toList());
    List<Employee> listActual = Stream.of(new Employee(1, "tushar", "kapadia", "dev", "tush"),
            new Employee(2, "tusharr", "kapadia", "dev", "tush"),
            new Employee(3, "tusharrr", "kapadia", "dev", "tush")).collect(Collectors.toList());
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    void saveEmployeeTestSuccess() {
        EmployeeDto employeeDto = new EmployeeDto(1, "tushar", "kapadia", "dev", "tush");
        Employee employee = listActual.get(0);
        when(employeeRepo.save(employee)).thenReturn(employee);
        try {
            assertThat(listExpected.get(0).equals(employeeServiceImpl.saveEmployee(employeeDto))).isEqualTo(true);
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void saveEmployeeTestFailure() {
        EmployeeDto employeeDto = new EmployeeDto(1, "tushar", "kapadia", "dev", "tush");
        Employee employee = listActual.get(0);
        when(employeeRepo.existsById(employeeDto.getId())).thenReturn(true);
        when(employeeRepo.save(employee)).thenReturn(employee);
        try {
            assertThat(listExpected.get(0).equals(employeeServiceImpl.saveEmployee(employeeDto))).isEqualTo(true);
            fail();
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void getEmployeeByManagerTest() {
        String manager = "tush";
        when(employeeRepo.findByManager(manager)).thenReturn(listActual);
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(manager);
        assertThat(listExpected.get(0).equals(list.get(0))).isEqualTo(true);
        assertThat(listExpected.get(1).equals(list.get(1))).isEqualTo(true);
        assertThat(listExpected.get(2).equals(list.get(2))).isEqualTo(true);
    }

    @Test
    void getEmployeeByIdSuccess() {
        int id = 1;
        when(employeeRepo.findById(id)).thenReturn(Optional.ofNullable(listActual.get(0)));
        try {
            Employee employee = employeeServiceImpl.getEmployeeById(id);
            assertThat(listExpected.get(0).equals(employee)).isEqualTo(true);
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }

    }

    @Test
    void getEmployeeByIdFailure() {
        int id = 1;
        try {
            Employee employee = employeeServiceImpl.getEmployeeById(id);
            fail();
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void updateEmployeeByIdSuccess() {
        int id = 1;
        EmployeeDto employeeDto = new EmployeeDto(3, "tusharrr", "kapadia", "dev", "tush");
        Employee employee = listActual.get(2);
        when(employeeRepo.findById(id)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepo.save(employee)).thenReturn(employee);
        try {
            Employee updatedEmp = employeeServiceImpl.updateEmployeeById(id, employeeDto);
            assertThat(listExpected.get(2).equals(updatedEmp)).isEqualTo(true);
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void updateEmployeeByIdFailure() {
        int id = 1;
        EmployeeDto employeeDto = new EmployeeDto(3, "tusharrr", "kapadia", "dev", "tush");
        Employee employee = listActual.get(2);
        when(employeeRepo.findById(id)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepo.save(employee)).thenReturn(employee);
        try {
            Employee updatedEmp = employeeServiceImpl.updateEmployeeById(2, employeeDto);
            fail();
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void deleteEmployeeByIdSuccess() {
        int id = 1;
        Employee employee = listActual.get(0);
        when(employeeRepo.findById(id)).thenReturn(Optional.ofNullable(employee));
        ;
        try {
            employeeServiceImpl.deleteEmployeeById(id);
            Employee expectedEmployee = employeeRepo.findById(id).orElse(null);
            if (expectedEmployee == null) {
                assertThat(true);
            }
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }

    @Test
    void deleteEmployeeByIdFailure() {
        int id = 1;
        Employee employee = listActual.get(0);
        when(employeeRepo.findById(id)).thenReturn(Optional.ofNullable(employee));
        doNothing().when(employeeRepo).delete(employee);
        try {
            employeeServiceImpl.deleteEmployeeById(5);
            fail();
        } catch (ResourceNotFoundException e) {
            assertThat(e.getErrorDto().getMessage());
        }
    }
}

