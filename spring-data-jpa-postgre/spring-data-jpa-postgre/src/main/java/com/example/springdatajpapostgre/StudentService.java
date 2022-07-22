package com.example.springdatajpapostgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentStorage studentStorage;

    @Autowired
    public StudentService(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
    }

    public List<Student> getAll(){
        return this.studentStorage.findAll();
    }

    public Student save(Student student){
        return this.studentStorage.save(student);
    }
}
