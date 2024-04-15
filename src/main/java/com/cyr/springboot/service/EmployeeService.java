package com.cyr.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.cyr.springboot.model.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesPage(Integer pageNo, Integer pageSize, String sortBy);
	public void updateEmployee(Employee employee, int employeeId);
	public void deleteEmployee(int id);
	public Optional<Employee> findById(int id);
	public Page<Employee> findPaginated(int pageNo, int pageSize);

}
