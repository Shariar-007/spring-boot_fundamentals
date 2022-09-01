package com.example.springdatajpapostgre;

import com.example.springdatajpapostgre.exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
    public ResponseEntity<List<Student>> getAll(){
//        throw new ApiRequestException("Oops cannot get all students with custom exception");
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }


    @GetMapping(path = "{studentId}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("studentId") Long studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        Student student1 = studentService.save(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<?> deletedById(@PathVariable("studentId") Long studentId){
        studentService.deleteById(studentId);
       return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable("studentId") Long studentId){
        return new ResponseEntity<>(studentService.update(student, studentId), HttpStatus.OK);
    }
}
