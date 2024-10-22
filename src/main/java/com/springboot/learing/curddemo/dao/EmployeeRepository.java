package com.springboot.learing.curddemo.dao;

import com.springboot.learing.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
