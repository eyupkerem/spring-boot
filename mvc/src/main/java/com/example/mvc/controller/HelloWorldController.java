package com.example.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // Before Request Param
    /*
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request , Model model){

        String theName = (request.getParameter("studentName")).toUpperCase();

        String result = "HELLO : " + theName;

        model.addAttribute("message" , result);


        return "helloworld";
    }

     */

    @GetMapping ("/processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName")String name , Model model){

        String result = ("HELLO : " + name).toUpperCase() ;

        model.addAttribute("message" , result);


        return "helloworld";
    }




}
