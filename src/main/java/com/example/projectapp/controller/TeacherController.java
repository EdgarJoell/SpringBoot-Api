package com.example.projectapp.controller;

import com.example.projectapp.model.Teacher;
import com.example.projectapp.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers/")
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping(path = "/teachers/")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }
}
