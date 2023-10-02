package com.example.lmspayment.controller;

import com.example.lmspayment.dto.PaymentDto;
import com.example.lmspayment.entity.Payment;
import com.example.lmspayment.entity.Student;
import com.example.lmspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> savePayment(@RequestBody PaymentDto paymentDto) {
        paymentService.savePayment(paymentDto);
        return ResponseEntity.ok("Saved success");

    }

    @GetMapping
    public List<Payment> getAllPayment() {
        return paymentService.getAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentPhoneNumber(@RequestParam String phoneNumber) {
        List<Student> students = paymentService.searchStudentPhoneNumber(phoneNumber);

        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatePayment) {
        Payment payment = paymentService.updatePayment(id, updatePayment);
        return ResponseEntity.ok(payment);

    }

}
