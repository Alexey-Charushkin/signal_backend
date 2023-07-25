package com.example.backend.telegrambot.messagesenders;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.springframework.context.ApplicationEvent;

/**
 * Класс MessageEvent расширяет ApplicationEvent и представляет собой событие отправки сообщения в Telegram.
 */
public class MessageEvent extends ApplicationEvent {
    // Сообщение, которое нужно отправить
    private SendMessage message;

    /**
     * Конструктор класса MessageEvent.
     *
     * @param source источник события
     * @param message сообщение, которое будет отправлено
     */
    public MessageEvent(Object source, SendMessage message) {
        super(source);
        this.message = message;
    }

    /**
     * Получает сообщение, которое будет отправлено.
     *
     * @return сообщение для отправки
     */
    public SendMessage getMessage() {
        return message;
    }
}
