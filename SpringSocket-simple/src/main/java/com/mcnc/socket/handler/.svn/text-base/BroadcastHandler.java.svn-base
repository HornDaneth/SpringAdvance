package com.mcnc.socket.handler;

import java.io.IOException;
import java.util.List;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import com.mcnc.socket.session.Sessions;


public class BroadcastHandler extends BinaryWebSocketHandler {
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		List<WebSocketSession> sessions = Sessions.getSessions();
		for (WebSocketSession webSocketSession : sessions) {
			try {
				webSocketSession.sendMessage(new TextMessage(message.getPayload()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
