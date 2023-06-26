package com.example.backend.telegrambot.handlers;

import com.example.backend.telegrambot.TelegramObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateHandler implements Handler{

    private final MessageUpdateHandler messageUpdateHandler;
    private final CallbackQueryHandler callbackQueryHandler;
    @Override
    public void handle(TelegramObject telegramObject) {
        try {
            if (telegramObject.isMessage()) {
                messageUpdateHandler.handle(telegramObject);
            } else if (telegramObject.isCallbackQuery()) {
                log.debug("Handling update for callback with data: {}, chat ID: {}", telegramObject.getData(), telegramObject.getId());
                callbackQueryHandler.handle(telegramObject);
            }
        } catch (Exception e) {
            log.error("An error occurred while handling the Telegram object", e);
        }
    }
}
