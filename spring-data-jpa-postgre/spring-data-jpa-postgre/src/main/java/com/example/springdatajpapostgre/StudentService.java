package com.example.springdatajpapostgre;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<Student> student1 = this.studentStorage.findStudentByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        return this.studentStorage.save(student);
    }

    public Optional<Student> getStudentById(Long studentId){
        return this.studentStorage.findById(studentId);
    }


    public void deleteById(Long studentId){
        boolean exits = this.studentStorage.existsById(studentId);
        if(!exits){
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }
        this.studentStorage.deleteById(studentId);
    }


    @Transactional
    public Student update(Student newStudent, Long studentId){
        Student student = this.studentStorage.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists"));
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());
        student.setAge(newStudent.getAge());
        return student;
    }
}
