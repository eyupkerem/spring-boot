package com.example.mvc.controller;

import com.example.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries ;

    @Value("${softwareLanguages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;




    @GetMapping("/showStudentForm")
    public String showFrom(Model themodel){

        Student theStudent = new Student();

        themodel.addAttribute("student", theStudent);

        themodel.addAttribute("countries" , countries);

        themodel.addAttribute("languages" , languages);

        themodel.addAttribute("systems",systems);




        return "student-form";

    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent ){

        System.out.println("theStudent : " + theStudent.getFirstName() + " "+ theStudent.getLastName());

        return "student-confirmation";

    }


}
