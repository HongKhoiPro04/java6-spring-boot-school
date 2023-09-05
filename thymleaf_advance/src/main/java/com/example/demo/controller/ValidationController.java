package com.example.demo.controller;

import com.example.demo.bean.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    @GetMapping("/validation/form")
    public String form(Model model){
        Student2 student = new Student2();
        model.addAttribute("sv",student);
        return "validation/form";
    }

    @PostMapping("validation/save")
    public String save(Model model, @Validated @ModelAttribute("sv") Student2 form, Errors errors){
       if(errors.hasErrors()){
           model.addAttribute("message","vui long sua cac loi sau");
           return "validation/form";
       }
        return "validation/success";
    }
}
