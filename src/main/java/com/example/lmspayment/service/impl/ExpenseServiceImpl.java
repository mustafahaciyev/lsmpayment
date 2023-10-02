package com.example.lmspayment.service.impl;

import com.example.lmspayment.config.Mapper;
import com.example.lmspayment.dto.ExpenseDto;
import com.example.lmspayment.entity.Expense;
import com.example.lmspayment.repos.ExpenseRepository;
import com.example.lmspayment.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final Mapper mapper;

    @Override
    public void saveExpense(ExpenseDto expenseDto) {
        Expense expense = mapper.getMapper().map(expenseDto, Expense.class);
        expenseRepository.save(expense);
    }
}
