package com.niit.collaboration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration // @Configuration to indicate that it is a Spring configuration class.	
@EnableWebSocketMessageBroker // @EnableWebSocketMessageBroker enables WebSocket message handling, backed by a message broker.
@ComponentScan("com.niit")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(WebSocketConfig.class);
    

  public WebSocketConfig() {
		super();
		System.out.println("->->->->WebSocketConfig object is created->->->->");
	}


@Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
	logger.debug("->->->->Starting method configureMessageBroker->->->->");
    config.enableSimpleBroker("/topic", "/queue");
    config.setApplicationDestinationPrefixes("/app");
    logger.debug("->->->->Ending method configureMessageBroker->->->->");
  }


  public void registerStompEndpoints(StompEndpointRegistry registry) {
	  logger.debug("->->->->Starting method registerStompEndpoints->->->->");
    registry.addEndpoint("/chat").withSockJS();
    registry.addEndpoint("/chat_forum").withSockJS();
    logger.debug("->->->->Ending method registerStompEndpoints->->->->");
  }
  
 /* The configureMessageBroker() method overrides the default method in 
  WebSocketMessageBrokerConfigurer to configure the message broker. 
  It starts by calling enableSimpleBroker() to enable a simple memory-based
   message broker to carry the greeting messages back to the client on
   destinations prefixed with "/topic". It also designates the "/app" prefix 
   for messages that are bound for @MessageMapping-annotated methods. 
   This prefix will be used to define all the message mappings; 
   for example, "/app/hello" is the endpoint that the GreetingController.greeting()
   method is mapped to handle.

  The registerStompEndpoints() method registers the "/gs-guide-websocket" 
  endpoint, enabling SockJS fallback options so that alternate transports 
  may be used if WebSocket is not available. The SockJS client will attempt 
  to connect to "/gs-guide-websocket" and use the best transport available 
  (websocket, xhr-streaming, xhr-polling, etc).*/
}