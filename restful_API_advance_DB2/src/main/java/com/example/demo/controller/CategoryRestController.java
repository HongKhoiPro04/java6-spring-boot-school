package com.example.demo.controller;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryRestController {
    @Autowired
    CategoryDao dao;

    @GetMapping("/rest/categories")
    public ResponseEntity<List<Category>> getAll(Model model){
        return ResponseEntity.ok(dao.findAll());
    }

    @GetMapping("/rest/categories/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") Integer id){
        if(!dao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dao.findById(id).get());
    }

    @PostMapping("/rest/categories")
    public ResponseEntity<Category> post(@RequestBody Category category){
        if(dao.existsById(category.getId())){
            return ResponseEntity.badRequest().build();
        }
        dao.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/categories/{id}")
    public ResponseEntity<Category> put(@PathVariable("id") Integer id,@RequestBody Category category){
        if (!dao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        dao.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/rest/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        if(!dao.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        dao.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
