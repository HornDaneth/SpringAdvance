package com.mcnc.socket.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class Sessions {
	protected static Map<String, WebSocketSession> map = new ConcurrentHashMap<String, WebSocketSession>();
	
	public static void addSession(String address, WebSocketSession session){
		map.put(address, session);
	}
	
	public static void remove(String address){
		map.remove(address);
	}
	
	public static List<WebSocketSession> getSessions(){
		List<WebSocketSession> list = new ArrayList<WebSocketSession>();
		Collection<WebSocketSession> values = map.values();
		for (WebSocketSession webSocketSession : values) {
			list.add(webSocketSession);
		}
		return list;
	}
}
