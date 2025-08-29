package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bkap.entity.ImportLog;

public interface ImportLogRepository extends JpaRepository<ImportLog, Long> {
   
}
