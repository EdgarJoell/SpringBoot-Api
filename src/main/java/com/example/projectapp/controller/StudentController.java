package com.example.projectapp.controller;

import com.example.projectapp.model.Student;
import com.example.projectapp.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentService studentService;

    @GetMapping(path = "/students/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
