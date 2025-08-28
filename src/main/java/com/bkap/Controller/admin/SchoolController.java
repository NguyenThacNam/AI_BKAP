package com.bkap.Controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entity.Schools;
import com.bkap.repository.SchoolsRepository;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolsRepository schoolRepository;

    public SchoolController(SchoolsRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public List<Schools> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schools> getSchoolById(@PathVariable Long id) {
        return schoolRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schools createSchool(@RequestBody Schools school) {
        return schoolRepository.save(school);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schools> updateSchool(@PathVariable Long id, @RequestBody Schools schoolDetails) {
        return schoolRepository.findById(id)
                .map(school -> {
                    school.setName(schoolDetails.getName());
                    school.setAddress(schoolDetails.getAddress());
                    return ResponseEntity.ok(schoolRepository.save(school));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        return schoolRepository.findById(id)
                .map(school -> {
                    schoolRepository.delete(school);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
