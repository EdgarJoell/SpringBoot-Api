package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.exception.InformationNotFoundException;
import com.example.projectapp.model.Teacher;
import com.example.projectapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher createTeacher(Teacher teacherObject) {
        Teacher teacher = teacherRepository.findByName(teacherObject.getName());
        if(teacher != null) {
            throw new InformationExistsException("Teacher with name " + teacher.getName() + " already exists.");
        } else {
            return teacherRepository.save(teacherObject);
        }
    }

    public Optional<Teacher> getTeacher(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if(teacher.isPresent()) {
            return teacher;
        } else {
            throw new InformationNotFoundException("Teacher with id " + teacherId + " does not exist.");
        }
    }
}
