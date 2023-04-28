package com.example.projectapp.repository;

import com.example.projectapp.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom findByName(String classroomName);
}
