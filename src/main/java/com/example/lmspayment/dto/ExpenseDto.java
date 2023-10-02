package com.example.lmspayment.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseDto {
    Double amount;
    Date checkDate;
    String checkName;
    String text;
    String checkUrl;
}
