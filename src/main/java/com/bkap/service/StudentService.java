package com.bkap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bkap.entity.ObjectType;
import com.bkap.entity.Student;
import com.bkap.entity.User;
import com.bkap.entity.UserRole;
import com.bkap.repository.StudentRepository;
import com.bkap.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired private StudentRepository studentRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Transactional
    public Student addStudent(Student student) {
        Student saved = studentRepository.save(student);

        User user = new User();
        user.setEmail(saved.getEmail());
        user.setPhone(saved.getPhone());
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRole(UserRole.STUDENT);
        user.setObjectType(ObjectType.STUDENT); 
        user.setObjectId(saved.getId());
        user.setStudentCode(saved.getCode());  
        user.setIsActive(true);

        userRepository.save(user);
        return saved;
    }
}
