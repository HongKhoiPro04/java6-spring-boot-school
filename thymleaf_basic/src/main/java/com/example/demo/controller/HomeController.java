package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String index(Model model) throws IOException {
        model.addAttribute("message","Welcome to Thymeleaf");

        ObjectMapper mapper = new ObjectMapper();
        String path = "D:\\java6\\thymleaf_basic\\src\\main\\resources\\static\\student.json";
        Student student = mapper.readValue(new File(path),Student.class);
        model.addAttribute("sv",student);

        return "home/index";
    }
}
