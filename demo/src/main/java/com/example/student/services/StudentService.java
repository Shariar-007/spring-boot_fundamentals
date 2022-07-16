package com.example.student.services;

import com.example.student.dao.StudentDao;
import com.example.student.models.Student;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService(@Qualifier("fakeStudentDao") StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Optional<Student> getStudentById(UUID id){
        return studentDao.getStudentById(id);
    }

    public int addStudent(Student student){
        studentDao.insertStudent(student);
        return 1;
    }

    public Student updateStudent(UUID id, Student student){
        return studentDao.updateStudent(id, student);
    }

    public int deleteStudent(UUID id){
        return studentDao.deleteStudent(id);
    }
}
