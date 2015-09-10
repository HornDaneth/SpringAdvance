package com.mcnc.socket.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.mcnc.socket.handler.BroadcastHandler;
import com.mcnc.socket.handler.TextHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer  {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(createTextHandler(), "/textHandler").addInterceptors(new SessionInterceptor()).withSockJS();
		registry.addHandler(createBroadcastHandler(), "/broadcastHandler").withSockJS();	
	}
	
	
	@Bean
    public TextHandler createTextHandler() {
        return new TextHandler();
    }
	
	@Bean
    public BroadcastHandler createBroadcastHandler() {
        return new BroadcastHandler();
    }
	
	@Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
	
}
