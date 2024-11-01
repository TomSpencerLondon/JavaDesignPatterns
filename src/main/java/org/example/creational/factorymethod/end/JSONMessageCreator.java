package org.example.creational.factorymethod.end;


import org.example.creational.factorymethod.end.message.JSONMessage;
import org.example.creational.factorymethod.end.message.Message;
import org.example.creational.factorymethod.end.message.TextMessage;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new JSONMessage();
	}

	
}
