package com.example.ms_app.employee.service;

import com.example.ms_app.employee.exception.UserNotFoundException;
import com.example.ms_app.employee.model.Employee;
import com.example.ms_app.employee.repository.EmployeeContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeContract employeeContract;

    @Autowired
    public EmployeeService(EmployeeContract employeeContract) {
        this.employeeContract = employeeContract;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeContract.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeContract.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeContract.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeContract.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " Was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeContract.deleteEmployeeById(id);
    }
}
