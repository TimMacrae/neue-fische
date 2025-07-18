package com.ecosystem.springstart.controller;

import com.ecosystem.springstart.controller.model.Message;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MessageRepo {
    @Getter
    private static List<Message> messages = new ArrayList<>();

    public Message addMessage(Message message) {
        messages.add(message);
        return message;
    }

    public void deleteMessage(String id) {
        messages = messages.stream().filter(message -> !message.getId().equals(id)).collect(Collectors.toList());
    }

}
