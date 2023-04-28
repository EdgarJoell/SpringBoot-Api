package com.example.projectapp.controller;

import com.example.projectapp.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentRepository studentRepository;
}
