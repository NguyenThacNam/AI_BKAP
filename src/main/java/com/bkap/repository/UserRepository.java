package com.bkap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bkap.entity.ObjectType;
import com.bkap.entity.User;
import com.bkap.entity.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Optional<User> findByStudentCode(String studentCode);
    
    List<User> findByRole(UserRole role);

    // Tìm theo objectType và objectId 
    List<User> findByObjectTypeAndObjectId(ObjectType objectType, Long objectId);
}
