package com.example.backend.telegrambot;

import com.example.backend.telegrambot.handlers.UpdateHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class TelegramBotApplication extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    private final UpdateHandler updateHandler;


    public TelegramBotApplication(@Value("${bot.token}") String botToken, UpdateHandler updateHandler) {
        super(botToken);
        this.updateHandler = updateHandler;
    }

    @Override
    public void onUpdateReceived(Update update) {

        var telegramObject = TelegramObject.getTelegramObject(update);

        try {
            updateHandler.handle(telegramObject);
        } catch (Exception e) {
            log.error("Все пропало " + e);
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
