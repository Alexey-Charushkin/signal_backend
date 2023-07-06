package com.example.backend.telegrambot;

import com.example.backend.telegrambot.handlers.UpdateHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.mockito.Mockito.verify;

public class TelegramBotApplicationTest {
    @Mock
    private UpdateHandler updateHandler;
    private TelegramBotApplication telegramBotApplication;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        telegramBotApplication = new TelegramBotApplication("test_bot_token", updateHandler);
    }

    @Test
    public void testOnUpdateReceived() {
        Update update = new Update();
        telegramBotApplication.onUpdateReceived(update);
        verify(updateHandler).handle(update);
    }
}
