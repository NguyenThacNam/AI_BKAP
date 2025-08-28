package com.bkap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entity.Teacher;
import com.bkap.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherAPI {

    @Autowired private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher saved = teacherService.addTeacher(teacher);
        return ResponseEntity.ok(saved);
    }
}

