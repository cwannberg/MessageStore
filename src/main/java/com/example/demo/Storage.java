package com.example.demo;

import com.example.demo.Model.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Storage implements MessageStoreInterface{
	private ArrayList<TextMessage> textMessages = new ArrayList<>();
	//AtomicInteger = An int value that may be updated atomically.
	private AtomicInteger nextId = new AtomicInteger();
	@Autowired
	TextMessage textMessage;

	public TextMessage writeNewTextMessage(@RequestBody TextMessage textMessage) {
		this.textMessage = textMessage;
		//Set TextMessage to have next unique ID:
		textMessage.setId(nextId.incrementAndGet());
		textMessages.add(textMessage);
		return textMessage;
	}

	public ArrayList<TextMessage> getAllTextMessages() {
		return textMessages;
	}

	public TextMessage getTextMessage(int textId) {
		for (TextMessage textMessage : textMessages) {
			if (textMessage.getId() == textId) {
				return textMessage;
			}
		}
		//Instead of just returning null I want to specify what's gone wrong.
		throw new IllegalArgumentException();
	}

	public TextMessage getTextMessage(String name) {
		for (TextMessage textMessage : textMessages) {
			if (textMessage.getName().equals(name)) {
				return textMessage;
			}
		}
		throw new IllegalArgumentException();
	}

	public TextMessage editTextMessage(int textId, TextMessage newTextMessage) {
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

	public TextMessage removeTextMessage(int textId) {
		for (TextMessage textMessage : textMessages) {
			if (textMessage.getId() == textId) {
				textMessages.remove(textMessage);
				return textMessage;
			}
		}
		throw new IllegalArgumentException();
	}
}
