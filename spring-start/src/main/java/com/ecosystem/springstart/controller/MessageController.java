package com.ecosystem.springstart.controller;


import com.ecosystem.springstart.controller.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/message")
public class MessageController {
    MessageRepo messageRepo = new MessageRepo();

    @GetMapping()
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(MessageRepo.getMessages());
    }

    @PostMapping()
    public ResponseEntity<String> addMessage(@RequestBody Message request) {
        Message message = messageRepo.addMessage(new Message(request.getId(), request.getName(), request.getMessage()));
        return ResponseEntity.ok("Add message: " + message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable String id) {
        messageRepo.deleteMessage(id);
        return ResponseEntity.ok("Message with id: " + id + " was deleted." );
    }
}
