package com.example.springdatajpapostgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(){
        return this.studentService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        this.studentService.save(student);
    }
}
