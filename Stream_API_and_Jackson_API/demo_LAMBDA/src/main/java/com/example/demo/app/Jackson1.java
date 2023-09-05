package com.example.demo.app;

import com.example.demo.bean.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson1 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    private static void demo2() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(path));
        students.iterator().forEachRemaining(student ->{
            System.out.println(">> Name: "+student.get("name").asText());
        });
    }

    private static void demo1() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        System.out.println("> > Name: "+ student.get("name").asText());
        System.out.println("> > Marks: "+ student.get("marks").asDouble());
        System.out.println("> > Gender: "+ student.get("gender").asBoolean());
        System.out.println("> > Email: "+ student.get("contact").get("email").asText());
        System.out.println("> > Phone: "+ student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(subjects -> {
            System.out.println("> > Subject:"+subjects.asText());
        });
    }
}
