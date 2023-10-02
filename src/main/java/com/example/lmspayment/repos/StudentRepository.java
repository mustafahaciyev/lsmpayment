package com.example.lmspayment.repos;

import com.example.lmspayment.entity.Student;
import com.example.lmspayment.service.StudentService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    Optional<Student> findByName(String studentName);


}
