package com.example.backend.telegrambot.handlers;

import com.example.backend.telegrambot.messagesenders.MessageSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import static org.mockito.Mockito.*;

class UpdateHandlerTest {

    @Mock
    private MessageSender messageSender;

    private UpdateHandler updateHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateHandler = new UpdateHandler(messageSender);
    }

    @Test
    void handleTextMessage() {
        // Создаем моки для зависимостей
        var message = mock(Message.class);
        var update = mock(Update.class);
        var user = mock(User.class);

        // Настраиваем моки для возвращения ожидаемых значений
        when(message.getText()).thenReturn("/start");
        when(message.getChatId()).thenReturn(1L);
        when(user.getFirstName()).thenReturn("Test User");
        when(message.getFrom()).thenReturn(user);
        when(update.hasMessage()).thenReturn(true);
        when(update.getMessage()).thenReturn(message);

        // Создаем моки для MessageSender и его SendMessage
        var messageSenderMock = mock(MessageSender.class);
        var sendMessageMock = mock(SendMessage.class);

        when(messageSender.newMessage()).thenReturn(messageSenderMock);
        when(messageSenderMock.setChatId(anyLong())).thenReturn(messageSenderMock);
        when(messageSenderMock.setText(anyString())).thenReturn(messageSenderMock);
        when(messageSenderMock.setInlineKeyboard(any())).thenReturn(messageSenderMock);
        doNothing().when(messageSenderMock).send();

        // Вызываем тестируемый метод
        updateHandler.handle(update);

        // Проверяем, что методы были вызваны с ожидаемыми значениями
        verify(messageSenderMock, times(2)).setChatId(1L);
        verify(messageSenderMock).setText("Привет Test User!\nМы рады приветствовать тебя в нашем новом боте!");
        verify(messageSenderMock).setText("Выберите интересующий для вас раздел");
    }

}
