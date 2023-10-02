package com.example.lmspayment.service.impl;

import com.example.lmspayment.config.Mapper;
import com.example.lmspayment.dto.CourseDto;
import com.example.lmspayment.entity.Course;
import com.example.lmspayment.entity.Student;
import com.example.lmspayment.exception.CourseNotFoundException;
import com.example.lmspayment.exception.StudentNotFoundException;
import com.example.lmspayment.repos.CourseRepository;
import com.example.lmspayment.repos.StudentRepository;
import com.example.lmspayment.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final Mapper mapper;


    @Override
    public void saveCourse(CourseDto courseDto) {
        Course course = mapper.getMapper().map(courseDto, Course.class);
        courseRepository.save(course);
    }

    @Override
    public Course getCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName).get();
    }

    @Override
    public Course updateCourse(Long id, Course updateCourse) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course == null){
            throw new EntityNotFoundException("Course not found");
        }
        course.setCourseName(updateCourse.getCourseName());
        course.setStudents(updateCourse.getStudents());
        course.setPayments(updateCourse.getPayments());
        return courseRepository.save(course);
    }

    @Override
    public void addStudent(String studentName, String courseName) {
        Course course = courseRepository.findByCourseName(courseName)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        Student student = studentRepository.findByName(studentName)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        course.getStudents().add(student);
        courseRepository.save(course);
    }
}
