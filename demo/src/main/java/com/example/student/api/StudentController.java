package com.example.student.api;

import com.example.student.models.Student;
import com.example.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
//    @GetMapping
//    public String getAllStudent(){
//        return "Hello World";
//    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id){
        return studentService.getStudentById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") UUID id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }
}
