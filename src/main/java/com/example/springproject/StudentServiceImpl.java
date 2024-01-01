package com.example.springproject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto getStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ExceptionHanler("no student found with id : "+id)
        );
        StudentDto studentDto = modelMapper.map(student,StudentDto.class);

        return studentDto;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> student = studentRepository.findAll();
        List<StudentDto> studentDtos = Arrays.asList(modelMapper.map(student,StudentDto[].class));

        return studentDtos;
    }

    @Override
    public void addStudent(Student student) {

        studentRepository.save(student);

        //return new ResponseEntity("Student added succesfully",HttpStatusCode.valueOf(200));
    }

    @Override
    public Student updateStudent(Student student, int id) {
        Student student1 = studentRepository.findById(id).orElseThrow(
                () -> new ExceptionHanler("no student found")
        );
        studentRepository.save(student1);

        return student;
    }

    @Override
    public Student patchStudent(Student student, int id) {
        return null;
    }

    @Override
    public ResponseEntity deleteStudent(int id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok().body("studend deleted succesfully");
    }
}
