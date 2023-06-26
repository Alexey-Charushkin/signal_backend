package com.example.backend.telegrambot.messagesenders;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    private SendMessage message;

    public MessageEvent(Object source, SendMessage message) {
        super(source);
        this.message = message;
    }

    public SendMessage getMessage() {
        return message;
    }
}
