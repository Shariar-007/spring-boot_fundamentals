package com.example.student.dao;

import com.example.student.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeStudentDao")
public class FakeStudentDatabase implements StudentDao {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public int insertStudent(UUID id, Student student) {
        studentList.add(new Student(id, student.getName(), student.getUniversityName(), student.getSemester(), student.getCgpa()));
        return 1;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Optional<Student> getStudentById(UUID id) {
        return studentList.stream().filter(student -> student.id.equals(id)).findFirst();
    }

    @Override
    public Student updateStudent(UUID id, Student newStudent) {
        getStudentById(id).map(student -> {
            int index = studentList.indexOf(student);
            if (index >= 0) {
                studentList.set(index, new Student(id, newStudent.getName(), newStudent.getUniversityName(), newStudent.getSemester(), newStudent.getCgpa()));
                return newStudent;
            }
            return null;
        });
        return null;
    }

    @Override
    public int deleteStudent(UUID id) {
        Optional<Student> student = getStudentById(id);
        if (student.isEmpty()) {
            return 0;
        }
        studentList.remove(student);
        return 0;
    }
}
