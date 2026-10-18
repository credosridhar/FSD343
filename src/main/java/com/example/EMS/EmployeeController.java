package com.example.EMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id).orElseThrow();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

}
