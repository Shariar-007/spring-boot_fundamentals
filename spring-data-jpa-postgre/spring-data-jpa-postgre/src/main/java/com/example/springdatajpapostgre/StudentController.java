package com.example.springdatajpapostgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long studentId){
        return this.studentService.getStudentById(studentId);
    }


    @PostMapping
    public void save(@RequestBody Student student){
        this.studentService.save(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deletedById(@PathVariable("studentId") Long studentId){
        this.studentService.deleteById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public Student update(@RequestBody Student student, @PathVariable("studentId") Long studentId){
        return this.studentService.update(student, studentId);
    }
}
