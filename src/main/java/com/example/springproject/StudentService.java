package com.example.springproject;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(int id);
    List<StudentDto> getAll();
    void addStudent(Student student);
    Student updateStudent(Student student, int id);
    Student patchStudent(Student student, int id);
    ResponseEntity deleteStudent(int id);

}
