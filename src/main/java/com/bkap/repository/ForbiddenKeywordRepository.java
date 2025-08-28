package com.bkap.repository;

import com.bkap.entity.ForbiddenKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForbiddenKeywordRepository extends JpaRepository<ForbiddenKeyword, Long> {
}