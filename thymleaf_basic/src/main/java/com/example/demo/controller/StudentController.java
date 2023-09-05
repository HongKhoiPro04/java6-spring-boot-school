package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String index(Model model,
                        @RequestParam("index")Optional<Integer> index) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File path = ResourceUtils.getFile("D:\\java6\\thymleaf_basic\\src\\main\\java\\com\\example\\demo\\bean\\students.json");
        TypeReference<List<Student>> typeref = new TypeReference<>() {};
        List<Student> students = mapper.readValue(path,typeref);

        int i = index.orElse(0);
        model.addAttribute("n",i);
        model.addAttribute("sv",students.get(i));
        return "scope/student";
    }
}
