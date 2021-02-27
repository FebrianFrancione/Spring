package com.test.crudDemoJPA.Dao;



import com.test.crudDemoJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
