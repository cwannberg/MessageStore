package com.example.demo.controllers;

import com.example.demo.MessageStoreInterface;
import com.example.demo.Model.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    MessageStoreInterface messageStoreInterface;

    @PostMapping("/textmessages")
    //Specifies that a new TextMessage is created. Instead of HttpStatus 200 we get 201.
    @ResponseStatus(HttpStatus.CREATED)
    public TextMessage writeNewTextMessage(@RequestBody TextMessage textMessage) {
        return messageStoreInterface.writeNewTextMessage(textMessage);
    }

    @GetMapping("/textmessages")
    public ArrayList<TextMessage> getAllTextMessages() {
        return messageStoreInterface.getAllTextMessages();
    }

    @GetMapping("/textmessages/{id}")
    public TextMessage getTextMessage(@PathVariable("id") int textId) {
        return messageStoreInterface.getTextMessage(textId);
    }

    @GetMapping("/textmessages/name={name}")
    public TextMessage getTextMessage(@PathVariable("name") String name) {
        return messageStoreInterface.getTextMessage(name);
    }

    @PostMapping("/textmessages/{id}")
    public TextMessage editTextMessage(@PathVariable("id") int textId,
                                       @RequestBody TextMessage newTextMessage) {
        return messageStoreInterface.editTextMessage(textId, newTextMessage);
    }

    @DeleteMapping("/textmessages/{id}")
    public TextMessage removeTextMessage(@PathVariable("id") int textId) {
        return messageStoreInterface.removeTextMessage(textId);
    }
}