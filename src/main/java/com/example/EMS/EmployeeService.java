package com.example.EMS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id){
		return repository.findById(id);
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}
	
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee updateEmployee(Long id, Employee updateEmployee) {
		Employee employee=repository.findById(id).orElseThrow();
		employee.setName(updateEmployee.getName());
		employee.setEmail(updateEmployee.getEmail());
		employee.setDepartment(updateEmployee.getDepartment());
		employee.setSalary(updateEmployee.getSalary());
		
		return repository.save(employee);
	}

}
