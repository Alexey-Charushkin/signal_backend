package com.example.backend.telegrambot.handlers;

import com.example.backend.telegrambot.TelegramObject;

public interface Handler {

    void handle(TelegramObject telegramObject);
}
