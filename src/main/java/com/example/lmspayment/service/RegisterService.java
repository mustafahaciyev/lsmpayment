package com.example.lmspayment.service;

import com.example.lmspayment.dto.LoginDto;
import com.example.lmspayment.dto.RegisterDto;

public interface RegisterService {
    void saveRegister(RegisterDto registerDto);

    Boolean login(LoginDto loginDto);
}
