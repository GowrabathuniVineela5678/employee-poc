package com.example.employeepoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepoc.entity.Employee;
import com.example.employeepoc.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeService service;
	
	public EmployeeController(EmployeeService service)
	{
		this.service =service;
	}
	@GetMapping("/{id}")

	 public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        return service.updateEmployee(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
