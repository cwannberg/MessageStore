package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class TextMessage {

    private int id;
    private String name;
    private String text;

    public TextMessage() {
    }

    public TextMessage(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
