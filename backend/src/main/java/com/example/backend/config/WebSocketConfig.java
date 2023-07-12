package com.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Конфигурационный класс для настройки соединения между клиентом и сервером по протоколу Websocket
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Метод для настройки брокера сообщений
     *
     * @param config    реестр для настройки брокера сообщений
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/order-notifications");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Метод для добавления ендпоинтов
     *
     * @param registry  реестр ендпоинтов для STOMP поверх WebSocket
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/new-orders").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/new-orders").setAllowedOrigins("*");
    }

}