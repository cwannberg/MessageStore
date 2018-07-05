package com.example.demo;

import com.example.demo.Model.TextMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Component
public interface MessageStoreInterface {

	//Post new textmessage
	TextMessage writeNewTextMessage(@RequestBody TextMessage textmessage);

	//Read all textmessages
	ArrayList<TextMessage> getAllTextMessages();

	//Read a specific textmessage by Id
	TextMessage getTextMessage(@PathVariable("id") int textId);

	//Read all textmessages written by author (name)
	TextMessage getTextMessage(@PathVariable("id") String name);

	//Update textmessage by Id
	TextMessage editTextMessage(int textId, @RequestBody TextMessage newTextMessage);

	//Delete textmessage by Id
	TextMessage removeTextMessage(@PathVariable("id") int textId);
}
