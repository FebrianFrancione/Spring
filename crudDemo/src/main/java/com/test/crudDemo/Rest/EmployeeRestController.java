package com.test.crudDemo.Rest;

import com.test.crudDemo.Dao.EmployeeDao;
import com.test.crudDemo.entity.Employee;
import com.test.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose /employees and return list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    //add mapping for /Get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found = " + employeeId);
        }
        return theEmployee;
    }

    //add mapping for POST
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    //add mapping for put
    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    //delete
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Emplyee id not found " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee Id = " + employeeId;
    }
}
