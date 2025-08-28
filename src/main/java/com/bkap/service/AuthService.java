package com.bkap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bkap.dto.LoginRequest;
import com.bkap.dto.LoginResponse;
import com.bkap.entity.ObjectType;
import com.bkap.entity.User;
import com.bkap.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mật khẩu không đúng");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole().name());
        response.setObjectType(user.getObjectType() != null ? user.getObjectType().name() : null);// ✅ Đúng kiểu
        response.setObjectId(user.getObjectId());
        response.setStudentCode(user.getStudentCode());

        return response;
    }
}

