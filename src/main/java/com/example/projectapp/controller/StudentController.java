package com.example.projectapp.controller;

import com.example.projectapp.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentService studentService;
}
