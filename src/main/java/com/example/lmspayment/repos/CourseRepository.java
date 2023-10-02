package com.example.lmspayment.repos;

import com.example.lmspayment.entity.Course;
import com.example.lmspayment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findByCourseName (String courseName);

//    Optional<Course> findByCourseName2(String courseName);
}
