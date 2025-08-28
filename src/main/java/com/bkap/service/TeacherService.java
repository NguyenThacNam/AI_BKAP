package com.bkap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bkap.entity.ObjectType;
import com.bkap.entity.Teacher;
import com.bkap.entity.User;
import com.bkap.entity.UserRole;
import com.bkap.repository.TeacherRepository;
import com.bkap.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        Teacher saved = teacherRepository.save(teacher);

        User user = new User();
        user.setEmail(saved.getEmail());
        user.setPhone(saved.getPhone());
        user.setPassword(passwordEncoder.encode("123456")); // mã hóa
        user.setRole(UserRole.TEACHER);
        user.setObjectType(ObjectType.TEACHER); 
        user.setObjectId(saved.getId()); 
        user.setIsActive(true);

        userRepository.save(user);
        return saved;
    }
}

