package com.example.projectapp.controller;

import com.example.projectapp.model.Teacher;
import com.example.projectapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/teachers/{teacherId}/")
    public Optional<Teacher> getTeacher(@PathVariable Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @PutMapping(path = "/teachers/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId, @RequestBody Teacher teacherObject) {
        return teacherService.updateTeacher(teacherId, teacherObject);
    }

    @DeleteMapping(path = "/teachers/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}
