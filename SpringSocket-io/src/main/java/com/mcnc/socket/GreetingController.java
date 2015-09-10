package com.mcnc.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	
	@Autowired
	private SimpMessagingTemplate messageSender;

	/**
	 * Static subscriber - /topic/greetings
	 * @param message
	 * @return
	 * @throws Exception
	 */
    @MessageMapping("/hello")    // set Mapped destination in SimpAnnotationMethodMessageHandler
    @SendTo("/topic/greetings")  // broadcast back to all broker/subscribers to channel /topic/greetings
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }
    
    
    /**
     * Dynamic subscriber
     * @param name
     * @param message
     */
    @MessageMapping("/hello/{name}")
    public void send(@DestinationVariable String name , HelloMessage message) {
    	messageSender.convertAndSend("/" + name, new Greeting("Hello, " + message.getName() + "!"));
    }

}
