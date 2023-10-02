package com.example.lmspayment.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    String name;
    String surname;
    String email;
    String phoneNumber;
}
