package com.example.backend.telegrambot;

import com.example.backend.telegrambot.handlers.UpdateHandler;
import com.example.backend.telegrambot.messagesenders.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Класс TelegramBotApplication представляет собой компонент Spring, который наследуется от TelegramLongPollingBot.
 * Он используется для обработки обновлений, полученных от Telegram API.
 */
@Component
@Slf4j
public class TelegramBotApplication extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    private final UpdateHandler updateHandler;

    /**
     * Конструктор класса TelegramBotApplication.
     *
     * @param botToken токен бота, полученный от BotFather.
     * @param updateHandler обработчик обновлений.
     */
    public TelegramBotApplication(@Value("${bot.token}") String botToken, UpdateHandler updateHandler) {
        super(botToken);
        this.updateHandler = updateHandler;
    }

    /**
     * Метод onUpdateReceived вызывается при получении нового обновления от Telegram API.
     *
     * @param update объект Update, содержащий информацию об обновлении.
     */
    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handle(update);
    }

    /**
     * Метод getBotUsername возвращает имя бота.
     *
     * @return имя бота.
     */
    @Override
    public String getBotUsername() {
        return botUsername;
    }

    /**
     * Метод handleMessageEvent вызывается при получении события MessageEvent.
     *
     * @param event объект MessageEvent, содержащий информацию о сообщении.
     */
    @EventListener
    public void handleMessageEvent(MessageEvent event) {
        try {
            execute(event.getMessage());
            log.debug("Сообщение успешно отправлено в чат с идентификатором: {}", event.getMessage().getChatId());
        } catch (TelegramApiException e) {
            log.debug("Ошибка при отправке сообщения пользователю: {}", e.getMessage());
            e.printStackTrace();
        }
    }

}
