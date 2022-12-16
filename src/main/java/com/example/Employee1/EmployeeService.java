package com.example.Employee1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository empRepo;
	
	public Employee create(Employee emp) {
		return empRepo.save(emp);
	}

	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public Optional<Employee> getById(String id) {
		return empRepo.findById(id);
	}
	
	public Employee update(String id,Employee emp) {
		emp.setId(id);
		return empRepo.save(emp);
	}
	
	public String delete(String id) {
		empRepo.deleteById(id);
		return "Employee with id : " + id + " deleted successfully.";
	}
}