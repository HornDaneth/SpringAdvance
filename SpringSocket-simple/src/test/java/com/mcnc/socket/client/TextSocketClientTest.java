package com.mcnc.socket.client;

import org.junit.Test;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.sockjs.client.SockJsClient;
public class TextSocketClientTest extends AbstractTest{

	@Test
	public void test() throws InterruptedException{
		SockJsClient sockJsClient = getSockClient();
		sockJsClient.doHandshake(new TextSocketClientHandler() , "http://localhost:8080/textHandler");
		Thread.sleep(2000);
	}
	

}

class TextSocketClientHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connected to " + session.getRemoteAddress() );
		session.sendMessage(new TextMessage("dara"));
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("Received:" + message.getPayload());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
