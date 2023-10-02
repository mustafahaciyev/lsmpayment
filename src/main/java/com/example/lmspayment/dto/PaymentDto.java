package com.example.lmspayment.dto;

import com.example.lmspayment.entity.Course;
import com.example.lmspayment.entity.Student;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDto {

    Double amount;
    Date checkDate;
    String courseMonth;
    String studentName;
    String courseName;
    String checkUrl;
    String cardHolder;


}
