package com.example.lmspayment.controller;

import com.example.lmspayment.dto.ExpenseDto;
import com.example.lmspayment.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apo")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/expense")
    public ResponseEntity<String> saveExpense(@RequestBody ExpenseDto expenseDto){
        expenseService.saveExpense(expenseDto);
        return ResponseEntity.ok("Saved success");
    }


}
