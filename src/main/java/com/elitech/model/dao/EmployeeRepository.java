package com.elitech.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
List<Employee> findByName(String name);
List<Employee> findByNameOrJob(String name,String job);
List<Employee> findByAgeLessThanEqual(int age);
List<Employee> findByAgeGreaterThan(int age);

}
