package com.example.lmspayment.controller;

import com.example.lmspayment.dto.StudentDto;
import com.example.lmspayment.entity.Student;
import com.example.lmspayment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apii")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
//
//    @GetMapping
//    public List<Student> getAll(){
//        return studentService.getAll();
//    }

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDto studentDto){

        studentService.saveSt(studentDto);
        return ResponseEntity.ok("Saved success");

    }

    @GetMapping("/{phoneNumber}")
    public List<Student> getStudentPhoneNumber(@PathVariable String phoneNumber){
        return studentService.getPhoneNumber(phoneNumber);

    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updateStudent){

        Student student = studentService.updateStudent(id,updateStudent);
        return ResponseEntity.ok(student);

    }

}
