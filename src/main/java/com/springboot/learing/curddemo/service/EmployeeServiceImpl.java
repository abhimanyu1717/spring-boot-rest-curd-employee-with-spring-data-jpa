package com.springboot.learing.curddemo.service;

import com.springboot.learing.curddemo.dao.EmployeeRepository;
import com.springboot.learing.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

       Optional<Employee> theEmployee =  employeeRepository.findById(id);

       if (theEmployee.isPresent()) {
           return theEmployee.get();
       } else {
           throw  new RuntimeException("Employee is not available - " + id);
       }

    }

    @Override
    public Employee save(Employee theEmployee) {
       return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
