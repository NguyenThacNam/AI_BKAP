package com.bkap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entity.ForbiddenKeyword;
import com.bkap.service.ForbiddenKeywordService;

@RestController
@RequestMapping("/api/forbidden-keywords")
public class ForbiddenKeywordController {

    @Autowired
    private ForbiddenKeywordService forbiddenKeywordService;

    @GetMapping
    public ResponseEntity<List<ForbiddenKeyword>> getAllForbiddenKeywords() {
        List<ForbiddenKeyword> keywords = forbiddenKeywordService.getAllForbiddenKeywords();
        return ResponseEntity.ok(keywords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForbiddenKeyword> getForbiddenKeywordById(@PathVariable Long id) {
        ForbiddenKeyword keyword = forbiddenKeywordService.getForbiddenKeywordById(id);
        return ResponseEntity.ok(keyword);
    }

    @PostMapping
    public ResponseEntity<ForbiddenKeyword> createForbiddenKeyword(@RequestBody ForbiddenKeyword forbiddenKeyword) {
        ForbiddenKeyword createdKeyword = forbiddenKeywordService.createForbiddenKeyword(forbiddenKeyword);
        return ResponseEntity.ok(createdKeyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForbiddenKeyword> updateForbiddenKeyword(@PathVariable Long id, @RequestBody ForbiddenKeyword forbiddenKeyword) {
        ForbiddenKeyword updatedKeyword = forbiddenKeywordService.updateForbiddenKeyword(id, forbiddenKeyword);
        return ResponseEntity.ok(updatedKeyword);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForbiddenKeyword(@PathVariable Long id) {
        forbiddenKeywordService.deleteForbiddenKeyword(id);
        return ResponseEntity.noContent().build();
    }
}