package com.example.projectapp.controller;

import com.example.projectapp.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/teachers/")
public class TeacherController {

    private TeacherService teacherService;
}
