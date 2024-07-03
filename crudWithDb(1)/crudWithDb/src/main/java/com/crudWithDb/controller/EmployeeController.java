package com.crudWithDb.controller;

import com.crudWithDb.entity.Employee;
import com.crudWithDb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

     @GetMapping("/list")
    public String listEmployees(Model theModel){
         List<Employee> theEmployees = employeeService.findAll();

         theModel.addAttribute("employees",theEmployees);

         return "employees/list-employees";

     }


     @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
     }

     @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
     }

     @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model theModel){

        Employee theEmployee = employeeService.findById(id);

        theModel.addAttribute(theEmployee);

        return "employees/employee-form";
     }

     @GetMapping("/delete")
    public String deleteUser(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
     }

}
