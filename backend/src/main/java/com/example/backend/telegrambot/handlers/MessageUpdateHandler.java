package com.example.backend.telegrambot.handlers;

import com.example.backend.telegrambot.TelegramObject;
import com.example.backend.telegrambot.keyboards.InlineKeyboardAssembler;
import com.example.backend.telegrambot.messagesenders.UserMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUpdateHandler implements Handler{

    private final UserMessageSender messageSender;
    @Override
    public void handle(TelegramObject telegramObject) {
        String messageText = telegramObject.getText();

        if (messageText.equals("/start")) {
            messageSender.clean(telegramObject);
            messageSender.sendMessage("Привет. Добро пожаловать в наш бот");

            messageSender.clean(telegramObject);
            var keyboard = InlineKeyboardAssembler.getInlineKeyboardWithWebApp();
            messageSender.sendMessageWithInlineKeyboard("Выберите меню", keyboard);
        }
    }
}
