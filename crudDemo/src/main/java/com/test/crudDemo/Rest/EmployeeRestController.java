package com.test.crudDemo.Rest;

import com.test.crudDemo.Dao.EmployeeDao;
import com.test.crudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeRestController(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }

    //expose /employees and return list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
}
