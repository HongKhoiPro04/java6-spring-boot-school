package com.example.demo.bean;

import java.util.List;

public class Student {
    String name;
    Boolean gender ;
    String email;
    Double marks = 0.0;
    Contact contact;
    List<String> subjects;
    public Student() {
    }

    public Student(String name, Boolean gender, String email, Double marks, Contact contact, List<String> subjects) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.marks = marks;
        this.contact = contact;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
