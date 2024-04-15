package com.cyr.springboot.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyr.springboot.model.Employee; 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Slice<Employee> findByEmail(String email, Pageable pageable);

}
