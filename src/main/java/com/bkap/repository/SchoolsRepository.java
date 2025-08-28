package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entity.Schools;

public interface SchoolsRepository extends JpaRepository<Schools, Long> {
}
