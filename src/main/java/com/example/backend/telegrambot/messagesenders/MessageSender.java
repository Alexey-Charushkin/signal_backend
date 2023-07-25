package com.example.backend.telegrambot.messagesenders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Класс MessageSender представляет собой компонент Spring, отвечающий за создание и отправку сообщений в Telegram.
 */
@Slf4j
@Component
public class MessageSender {

    // Публикатор событий
    private final ApplicationEventPublisher eventPublisher;
    // Сообщение для отправки
    private SendMessage sendMessage;

    /**
     * Конструктор класса MessageSender.
     *
     * @param eventPublisher публикатор событий
     */
    @Autowired
    public MessageSender(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.sendMessage = new SendMessage();
    }

    /**
     * Создает новое сообщение.
     *
     * @return объект этого MessageSender для цепочки вызовов методов
     */
    public MessageSender newMessage () {
        this.sendMessage = new SendMessage();
        return this;
    }

    /**
     * Устанавливает идентификатор чата.
     *
     * @param chatId идентификатор чата
     * @return объект этого MessageSender для цепочки вызовов методов
     */
    public MessageSender setChatId (Long chatId) {
        sendMessage.setChatId(chatId);
        return this;
    }

    /**
     * Устанавливает текст сообщения.
     *
     * @param text текст сообщения
     * @return объект этого MessageSender для цепочки вызовов методов
     */
    public MessageSender setText (String text) {
        sendMessage.setText(text);
        return this;
    }

    /**
     * Устанавливает клавиатуру встроенных кнопок.
     *
     * @param keyboard клавиатура встроенных кнопок
     * @return объект этого MessageSender для цепочки вызовов методов
     */
    public MessageSender setInlineKeyboard (InlineKeyboardMarkup keyboard) {
        sendMessage.setReplyMarkup(keyboard);
        return this;
    }

    /**
     * Отправляет сообщение, используя публикатор событий.
     */
    public void send() {
        sendMessage.enableMarkdown(true);
        sendMessage.enableHtml(true);

        try {
            eventPublisher.publishEvent(new MessageEvent(this, sendMessage));
            log.debug("Событие сообщения опубликовано для идентификатора чата: {}", sendMessage.getChatId());
        } catch (Exception e) {
            log.error("Ошибка при отправке сообщения пользователю: {}", e.getMessage());
        }
    }
}
