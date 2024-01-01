package com.example.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "getting student by id");
        httpHeaders.add("description", "fetching from db");

        //using static builder from response entity
        return ResponseEntity.ok().headers(httpHeaders).body(studentService.getStudentById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentDto>> getAllStudent(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "getting student by id");
        httpHeaders.add("description", "fetching from db");

        //using constructor from response entity
        ResponseEntity<List<StudentDto>> responseEntity = new ResponseEntity(studentService.getAll(),httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        ResponseEntity<String> responseEntity = ResponseEntity.ok()
                //can use string header directly or use HttpHeaders
                .header("info","adding student")
                .header("desc","addeing students to db")
                .body("succesfully added the student");
        //if there is no body we need to build it, like below

        ResponseEntity<String> responseEntity1 = ResponseEntity.ok()
                .header("info","adding student")
                .header("desc","addeing students to db")
                .build();
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(student,id);
    }

    @PatchMapping("/patch/{id}")
    public Student patchStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.patchStudent(student,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
