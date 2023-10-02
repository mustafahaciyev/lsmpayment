package com.example.lmspayment.exception;

import com.example.lmspayment.entity.Student;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException (String message){
        super(message);
    }
}
