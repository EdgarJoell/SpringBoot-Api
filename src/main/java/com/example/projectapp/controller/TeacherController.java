package com.example.projectapp.controller;

import com.example.projectapp.model.Teacher;
import com.example.projectapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers/")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherRepository(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/teachers/")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping(path = "/teachers/")
    public Teacher createTeacher(@RequestBody Teacher teacherObject) {
        return teacherService.createTeacher(teacherObject);
    }
}
