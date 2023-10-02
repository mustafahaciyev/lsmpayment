package com.example.lmspayment.controller;

import com.example.lmspayment.dto.CourseDto;
import com.example.lmspayment.entity.Course;
import com.example.lmspayment.service.CourseService;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/apies")
@RequiredArgsConstructor
public class CourseController {
     private final CourseService courseService;

     @PostMapping("/course")
    public ResponseEntity<String> saveCourse(@RequestBody CourseDto courseDto){
         courseService.saveCourse(courseDto);
         return ResponseEntity.ok("Saved success");
     }

     @GetMapping("/search")
    public ResponseEntity<Course> searchCourseName(@RequestParam String courseName){

         Course course = courseService.getCourseName(courseName);

         if (course != null){
             return ResponseEntity.ok(course);
         } else {
             return ResponseEntity.notFound().build();
         }

     }

     @PutMapping("{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updateCourse){
         Course updated = courseService.updateCourse(id,updateCourse);
         return ResponseEntity.ok(updated);
     }

     @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Map<String,String> request){
         String studentName = request.get("studentName");
         String courseName = request.get("courseName");
         courseService.addStudent(studentName,courseName);
         return ResponseEntity.ok("Student added to course");
     }

}
