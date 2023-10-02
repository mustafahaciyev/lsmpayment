package com.example.lmspayment.service;

import com.example.lmspayment.dto.CourseDto;
import com.example.lmspayment.entity.Course;

public interface CourseService {
    void saveCourse(CourseDto courseDto);

    Course getCourseName(String courseName);

    Course updateCourse(Long id, Course updateCourse);

    void addStudent(String studentName, String courseName);
}
