package com.crudDAO.rest;

import com.crudDAO.dao.EmployeeDAO;
import com.crudDAO.entity.Employee;
import com.crudDAO.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee findedEmployee = employeeService.findById(employeeId);

        if (findedEmployee == null){
            throw new RuntimeException("Employee id not found");
        }
        return  findedEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee deletingEmployee = employeeService.findById(employeeId);

        if (deletingEmployee == null){
            throw new RuntimeException("Employee id not found : " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Employee deleted id : " + employeeId;


    }


}
