package org.example.creational.factorymethod.end;


import org.example.creational.factorymethod.end.message.Message;
import org.example.creational.factorymethod.end.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}



}
