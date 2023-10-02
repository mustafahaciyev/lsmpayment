package com.example.lmspayment.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException (String message){
        super(message);
    }
}
