package com.mcnc.socket.handler;

import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mcnc.socket.session.Sessions;

// or BinaryWebSocketHandler or WebSocketHandler 
public class TextHandler extends TextWebSocketHandler{
	
	public  TextHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		CharSequence payload = String.format("We got a message '%s' from %s", message.getPayload(), 
				session.getRemoteAddress());
		
		Map<String, Object> attributes = session.getAttributes();
		
		
		TextMessage response = new TextMessage(payload );
		session.sendMessage(response);
	}
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Sessions.addSession(session.getRemoteAddress().toString(), session);
		super.afterConnectionEstablished(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Sessions.remove(session.getRemoteAddress().toString());
		super.afterConnectionClosed(session, status);
	}
	
}
