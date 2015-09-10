package com.mcnc.socket.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public abstract class AbstractTest {
	protected SockJsClient getSockClient(){
		List<Transport> transports = new ArrayList<Transport>(2);
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		//transports.add(new WebSocketTransport(new JettyWebSocketClient()));
		
		transports.add(new RestTemplateXhrTransport());

		SockJsClient sockJsClient = new SockJsClient(transports);
		
		return sockJsClient;
	}
}
