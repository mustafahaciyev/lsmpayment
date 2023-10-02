package com.example.lmspayment.service.impl;

import com.example.lmspayment.config.Mapper;
import com.example.lmspayment.dto.LoginDto;
import com.example.lmspayment.dto.RegisterDto;
import com.example.lmspayment.entity.Register;
import com.example.lmspayment.repos.RegisterRepository;
import com.example.lmspayment.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
    private final Mapper mapper;


    @Override
    public void saveRegister(RegisterDto registerDto) {
        Register register = mapper.getMapper().map(registerDto, Register.class);
        registerRepository.save(register);
    }

    @Override
    public Boolean login(LoginDto loginDto) {
        Register register = registerRepository.findByUserName(loginDto.getUserName());
        if (register != null && register.getPassword().equals(loginDto.getPassword())){
            return true;
        }

        return false;
    }



}
