package com.example.lmspayment.service;

import com.example.lmspayment.dto.PaymentDto;
import com.example.lmspayment.entity.Payment;
import com.example.lmspayment.entity.Student;

import java.util.List;

public interface PaymentService {


    Payment savePayment(PaymentDto paymentDto);

    List<Payment> getAll();

    List<Student> searchStudentPhoneNumber(String phoneNumber);

    Payment updatePayment(Long id, Payment updatePayment);
}
