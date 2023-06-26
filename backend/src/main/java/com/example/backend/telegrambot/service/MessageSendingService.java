package com.example.backend.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSendingService {
    public Message execute(TelegramLongPollingBot bot, SendMessage sendMessage) throws TelegramApiException {
        return bot.execute(sendMessage);
    }
}