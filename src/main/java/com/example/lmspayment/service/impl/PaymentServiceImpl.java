package com.example.lmspayment.service.impl;

import com.example.lmspayment.config.Mapper;
import com.example.lmspayment.dto.PaymentDto;
import com.example.lmspayment.entity.Course;
import com.example.lmspayment.entity.Payment;
import com.example.lmspayment.entity.Student;
import com.example.lmspayment.repos.CourseRepository;
import com.example.lmspayment.repos.PaymentRepository;
import com.example.lmspayment.repos.StudentRepository;
import com.example.lmspayment.service.PaymentService;
import com.example.lmspayment.specification.PaymentSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final Mapper mapper;


    @Override
    public Payment savePayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setCheckDate(paymentDto.getCheckDate());
        payment.setCourseMonth(paymentDto.getCourseMonth());
        payment.setCheckUrl(paymentDto.getCheckUrl());
        payment.setCardHolder(paymentDto.getCardHolder());

        Student student = studentRepository.findByName(paymentDto.getStudentName()).get();
        payment.setStudent(student);

        Course course = courseRepository.findByCourseName(paymentDto.getCourseName()).get();
        payment.setCourse(course);

        return paymentRepository.save(payment);

    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Student> searchStudentPhoneNumber(String phoneNumber) {
        Specification<Student> spec = PaymentSpecification.hasPhoneNumber(phoneNumber);
        return studentRepository.findAll(spec);
    }

    @Override
    public Payment updatePayment(Long id, Payment updatePayment) {
       Payment payment = paymentRepository.findById(id).orElse(null);
       if (payment == null){
           throw new EntityNotFoundException("Payment Not found");
       }
       payment.setAmount(updatePayment.getAmount());
       payment.setCourseMonth(updatePayment.getCourseMonth());
       payment.setCheckUrl(updatePayment.getCheckUrl());
       payment.setCardHolder(updatePayment.getCardHolder());
       payment.setCheckDate(updatePayment.getCheckDate());
       payment.setStudent(updatePayment.getStudent());
       payment.setCourse(updatePayment.getCourse());
       return paymentRepository.save(payment);

    }


}
