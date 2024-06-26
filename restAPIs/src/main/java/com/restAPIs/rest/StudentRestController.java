package com.restAPIs.rest;

import com.restAPIs.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Alex","Jal"));
        theStudents.add(new Student("Jack","Beck"));
        theStudents.add(new Student("Daniel","Rick"));
        theStudents.add(new Student("Cassie","Dykstra"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

       return theStudents;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){

        if ((studentID >= theStudents.size()) || (studentID < 0) ){
            throw new StudentNotFoundException("Student id not found : "+ studentID);
        }
        return theStudents.get(studentID);
    }








}
