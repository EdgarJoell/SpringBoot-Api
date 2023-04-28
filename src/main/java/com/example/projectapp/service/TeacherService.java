package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.model.Teacher;
import com.example.projectapp.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher createTeacher(Teacher teacherObject) {
        Teacher teacher = teacherRepository.findByName(teacherObject.getName());
        if(teacher != null) {
            throw new InformationExistsException("Teacher with name " + teacher.getName() + " already exists.");
        } else {
            return teacherRepository.save(teacher);
        }
    }
}
