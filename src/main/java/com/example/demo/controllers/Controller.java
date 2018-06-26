package com.example.demo.controllers;

import com.example.demo.Model.TextMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private ArrayList<TextMessage> textMessages = new ArrayList<>();
    //AtomicInteger = An int value that may be updated atomically.
    private AtomicInteger nextId = new AtomicInteger();

    @PostMapping("/textmessages")
    @ResponseStatus(HttpStatus.CREATED)
    //Specifies that a new TextMessage is created. Instead of HttpStatus 200 we get 201.
    public TextMessage writeNewTextMessage(@RequestBody TextMessage textMessage) {
        //Set TextMessage to have next unique ID:
        textMessage.setId(nextId.incrementAndGet());

        textMessages.add(textMessage);
        return textMessage;
    }

    @GetMapping("/textmessages")
    public ArrayList<TextMessage> getAllTextMessages() {
        return textMessages;
    }

    @GetMapping("/textmessages/{id}")
    public TextMessage getTextMessage(@PathVariable("id") int textId) {
        for (TextMessage textMessage : textMessages) {
            if (textMessage.getId() == textId) {
                return textMessage;
            }
        }
        //Instead of just returning null I want to specify what's gone wrong.
        throw new IllegalArgumentException();
    }

    @GetMapping("/textmessages/name={name}")
    public TextMessage getTextMessage(@PathVariable("name") String name) {
        for (TextMessage textMessage : textMessages) {
            if (textMessage.getName().equals(name)) {
                return textMessage;
            }
        }
        throw new IllegalArgumentException();
    }

    @PostMapping("/textmessages/{id}")
    public TextMessage editTextMessage(@PathVariable("id") int textId,
                                       @RequestBody TextMessage newTextMessage) {
        for (TextMessage textMessage : textMessages) {
            if (textMessage.getId() == textId) {
                textMessages.remove(textMessage);
                newTextMessage.setId(textId);
                textMessages.add(newTextMessage);
                return textMessage;
            }
        }
        throw new IllegalArgumentException();
    }

    @DeleteMapping("/textmessages/{id}")
    public TextMessage removeTextMessage(@PathVariable("id") int textId) {
        for (TextMessage textMessage : textMessages) {
            if (textMessage.getId() == textId) {
                textMessages.remove(textMessage);
                return textMessage;
            }
        }
        throw new IllegalArgumentException();
    }
}