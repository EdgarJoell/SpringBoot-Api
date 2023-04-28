package com.example.projectapp.controller;

import com.example.projectapp.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/teachers/")
public class TeacherController {

    private TeacherRepository teacherRepository;
}
