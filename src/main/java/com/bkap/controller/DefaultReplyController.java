package com.bkap.Controller;

import com.bkap.entity.DefaultReply;
import com.bkap.service.DefaultReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/default-replies")
public class DefaultReplyController {

    @Autowired
    private DefaultReplyService defaultReplyService;

    @GetMapping
    public ResponseEntity<List<DefaultReply>> getAllDefaultReplies() {
        List<DefaultReply> replies = defaultReplyService.getAllDefaultReplies();
        return ResponseEntity.ok(replies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultReply> getDefaultReplyById(@PathVariable Long id) {
        try {
            DefaultReply reply = defaultReplyService.getDefaultReplyById(id);
            return ResponseEntity.ok(reply);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<DefaultReply> createDefaultReply(@RequestBody DefaultReply defaultReply) {
        DefaultReply createdReply = defaultReplyService.createDefaultReply(defaultReply);
        return ResponseEntity.status(201).body(createdReply);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultReply> updateDefaultReply(@PathVariable Long id, @RequestBody DefaultReply defaultReply) {
        try {
            DefaultReply updatedReply = defaultReplyService.updateDefaultReply(id, defaultReply);
            return ResponseEntity.ok(updatedReply);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefaultReply(@PathVariable Long id) {
        try {
            defaultReplyService.deleteDefaultReply(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}