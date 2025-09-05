package com.example.employeepoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepoc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
