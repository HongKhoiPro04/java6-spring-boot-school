package com.example.demo.app;

import com.example.demo.bean.Contact;
import com.example.demo.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jackson2 {
    public static void main(String[] args) throws IOException {
        demo7();
    }

    private static void demo7() throws IOException {
        Contact contact = new Contact("teonv@gmail.com","099876544",null);
        List<String> subjects = Arrays.asList("WEB205","COM108");
        Student2 student = new Student2("Nguyen Van Teo",true,7.5,contact,subjects);
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(student);

        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student);

        mapper.writeValue(new File("D:/student.json"),student);

    }

    private static void demo6() throws IOException {
        Map<String,Object> contact = new HashMap<String,Object>();
        contact.put("email","teonv@gmail.com");
        contact.put("phone","099987654");

        List<String> subjects = Arrays.asList("WEB205","COM108");

        Map<String,Object> student = new HashMap<String,Object>();
        student.put("name","Nguyen van Teo");
        student.put("marks",7.5);
        student.put("gender",true);
        student.put("contact",contact);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(student);


        System.out.println(json);

        mapper.writeValue(System.out,student);

        mapper.writeValue(new File("D:/student.json"),student);

    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name","Nguyen van Teo");
        student.put("marks",7.5);
        student.put("gender",true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email","teonv@gmail.com");
        contact.put("phone","0988766677");
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("WEB205");
        subjects.add("COM108");

        String json = mapper.writeValueAsString(student);

        mapper.writeValue(System.out,student);

        mapper.writeValue(new File("D:/student.json"),student);
    }

    private static void demo4() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\students.json";
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {};
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(path),type);
        students.forEach(student -> {
            System.out.println(">> Name: "+student.getName());
        });
    }

    private static void demo3() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path),Student2.class);

        System.out.println(">> Name: "+student.getName());
        System.out.println(">> Marks: "+student.getMarks());
        System.out.println(">> Gender: "+student.getGender());
        Contact contact = student.getContact();
        System.out.println(">> Email: " +contact.getEmail());
        System.out.println(">> Phone: "+contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(subject -> {
            System.out.println(">> Subject: "+subject);
        });
    }

    private static void demo2() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,Object>> students = mapper.readValue(new File(path),List.class);
        students.forEach(student -> {
            System.out.println(">> Name: "+student.get("name"));
        });
    }

    private static void demo1() throws IOException {
        String path = "D:\\java6\\Stream_API_and_Jackson_API\\demo_LAMBDA\\src\\main\\resources\\static\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> student = mapper.readValue(new File(path),Map.class);

        System.out.println(">> Name: "+student.get("name"));
        System.out.println(">> Marks: "+student.get("marks"));
        System.out.println(">> Gender: "+student.get("gender"));
        Map<String,Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">> Email: " +contact.get("email"));
        System.out.println(">> Phone: "+contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(subject -> {
            System.out.println(">> Subject: "+subject);
        });

    }
}
