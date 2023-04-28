package com.example.projectapp.controller;

import com.example.projectapp.model.Student;
import com.example.projectapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentService studentService;

    @GetMapping(path = "/students/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "/students/")
    public Student createStudent(@RequestBody Student studentObject) {
        return studentService.createStudent(studentObject);
    }
}
