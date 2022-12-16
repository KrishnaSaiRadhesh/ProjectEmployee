package com.example.Employee1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@Autowired
	public EmployeeService service;
	
	@PostMapping("/Post Employee")
	public Employee createEmployee(@Validated @RequestBody Employee emp) {
		return service.create(emp);
	}
	
	@GetMapping("/Get employees")
	public List<Employee> getAllEmployees() {
		return service.getAll();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id) {
		return service.getById(id);
	}
	
	@PutMapping("/Put employee/{id}") 
	public Employee updateEmployee(@PathVariable String id, @Validated @RequestBody Employee emp) {
		return service.update(id, emp);
	}
	
	@DeleteMapping("/Delete employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		service.delete(id);
		return "Employee with Id : " + id + " deleted successfully.";
	}
}
