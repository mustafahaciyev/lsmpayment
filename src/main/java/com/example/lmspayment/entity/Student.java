package com.example.lmspayment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String phoneNumber;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<Payment> payments;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    List<Course> courses;


}