package com.example.lmspayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFound(StudentNotFoundException st){
        return new ResponseEntity<>("Error message: " + st.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> courseNotFound(CourseNotFoundException cr){
        return new ResponseEntity<>("Error message: " + cr.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
