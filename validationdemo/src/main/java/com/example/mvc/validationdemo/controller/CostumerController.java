package com.example.mvc.validationdemo.controller;


import com.example.mvc.validationdemo.Costumer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CostumerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);

    }



    @GetMapping("/")
    public String showForm(Model themodel){

        themodel.addAttribute("costumer" , new Costumer());

        return "costumer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("costumer") Costumer theCostumer , BindingResult theBindingResult)
    {

        System.out.println("Last Name : |"+  theCostumer.getLastName()+"|");


        System.out.println("Bindin results + " + theBindingResult.toString());

        System.out.println("\n\n\n\n");

        if(theBindingResult.hasErrors()){
            return "costumer-form";
        }
        else {
            return "costumer-confirmation";
        }
    }
}

