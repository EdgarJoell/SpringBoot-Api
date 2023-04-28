package com.example.projectapp.service;

import com.example.projectapp.model.Classroom;
import com.example.projectapp.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private ClassroomRepository classroomRepository;

    public List<Classroom> getClassrooms () {
        return classroomRepository.findAll();
    }
}
