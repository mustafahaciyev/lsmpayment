package com.example.lmspayment.service.impl;

import com.example.lmspayment.config.Mapper;
import com.example.lmspayment.dto.StudentDto;
import com.example.lmspayment.entity.Student;
import com.example.lmspayment.repos.StudentRepository;
import com.example.lmspayment.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final Mapper mapper;


//    @Override
//    public List<Student> getAll() {
//        return studentRepository.findAll();
//    }

    @Override
    public void saveSt(StudentDto studentDto) {
        Student map = mapper.getMapper().map(studentDto, Student.class);
        studentRepository.save(map);
    }



    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null){
            throw new EntityNotFoundException("Student not found");
        }
        student.setName(updateStudent.getName());
        student.setEmail(updateStudent.getEmail());
        student.setSurname(updateStudent.getSurname());
        student.setPhoneNumber(updateStudent.getPhoneNumber());
        student.setCourses(updateStudent.getCourses());
        student.setPayments(updateStudent.getPayments());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getPhoneNumber(String phoneNumber) {
        Specification<Student> specification = phoneNumber(phoneNumber);
        return studentRepository.findAll(specification);
    }

    public Specification<Student> phoneNumber(String phoneNumber) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
    }

}
