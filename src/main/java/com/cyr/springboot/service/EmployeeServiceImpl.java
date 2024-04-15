package com.cyr.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cyr.springboot.dao.EmployeeRepository;
import com.cyr.springboot.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired  
	EmployeeRepository employeeRepository;  
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}

	@Override
	public void updateEmployee(Employee employee, int employeeId) {
		System.out.println("employee data is updating ");
		
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
		
	}

	@Override
	public List<Employee> getAllEmployeesPage(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
	}
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
	 Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
	 return this.employeeRepository.findAll(pageable);
	}

}