package com.example.lmspayment.controller;

import com.example.lmspayment.dto.LoginDto;
import com.example.lmspayment.dto.RegisterDto;
import com.example.lmspayment.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Boolean isTrue = registerService.login(loginDto);
        if (isTrue){
            return ResponseEntity.ok("Okey");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
        }

    }
    @PostMapping("/register")
    public ResponseEntity<String> saveRegister(@RequestBody RegisterDto registerDto){

        try {
            registerService.saveRegister(registerDto);
            return ResponseEntity.ok("Successfully");
        }catch (Exception e){
            String message = "Xeta durumu" + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

    }


}
