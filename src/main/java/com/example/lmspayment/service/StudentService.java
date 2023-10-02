package com.example.lmspayment.service;

import com.example.lmspayment.dto.StudentDto;
import com.example.lmspayment.entity.Student;

import java.util.List;

public interface StudentService {
//    List<Student> getAll();

    void saveSt(StudentDto studentDto);

    List<Student> getPhoneNumber(String phoneNumber);

    Student updateStudent(Long id, Student updateStudent);
}
