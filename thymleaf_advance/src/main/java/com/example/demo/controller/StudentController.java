package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/student/form")
    public String form(Model model){
        Student student = new Student();
        student.setFullName("Pham Hong Khoi");
        student.setCountry("VN");
        student.setGender(true);
        model.addAttribute("sv",student);
        return "student/form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form){

        return "student/success";
    }

}
