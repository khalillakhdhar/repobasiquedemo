package com.elitech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elitech.model.Employee;
import com.elitech.model.dao.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping
	public List<Employee> getAll()
	{
		return employeeRepository.findAll();
	}
	@PostMapping
	public Employee addOne(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	@GetMapping("/{id}")
	public Employee findOne(@PathVariable long id)
	{
		return employeeRepository.findById(id).get();
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id)
	{
		 employeeRepository.deleteById(id);
	}
	@GetMapping("/searchNom")
	public List<Employee> getByNom(@RequestParam String nom)
	{
		return employeeRepository.findByName(nom);
	}
	
	
}
