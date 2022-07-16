package com.example.student.dao;

import com.example.student.models.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {

    int insertStudent(UUID id, Student student);


    default int insertStudent(Student student){
        UUID id = UUID.randomUUID();
        return insertStudent(id, student);
    }

    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(UUID id);

    public Student updateStudent(UUID id, Student student);

    public int deleteStudent(UUID id);




}
