package com.example.projectapp.repository;

import com.example.projectapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByName(String teacherName);
}
