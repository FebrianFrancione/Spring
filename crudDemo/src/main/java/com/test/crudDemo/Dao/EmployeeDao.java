package com.test.crudDemo.Dao;

import com.test.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int  theId);
    public void save(Employee theEmployee);
    public void deleteById(int  theId);
}
