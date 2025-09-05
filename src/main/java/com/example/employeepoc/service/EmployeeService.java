package com.example.employeepoc.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employeepoc.entity.Employee;
import com.example.employeepoc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
private final EmployeeRepository repo;
public EmployeeService(EmployeeRepository repo)
{
	this.repo=repo;
}
public Optional<Employee> getEmployeeById(Long id)
{
	return repo.findById(id);
	
}
public Optional<Employee> updateEmployee(Long id, Employee newData) {
    return repo.findById(id).map(employee -> {
        employee.setName(newData.getName());
        employee.setDepartment(newData.getDepartment());
        employee.setSalary(newData.getSalary());
        return repo.save(employee);
    });

}
}
