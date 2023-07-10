package com.example.backend.telegrambot.handlers;

import com.example.backend.telegrambot.keyboards.InlineKeyboardAssembler;
import com.example.backend.telegrambot.messagesenders.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Компонент для обработки обновлений от Telegram бота.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateHandler {

    private final MessageSender messageSender;

    /**
     * Обработка пришедших обновлений.
     *
     * @param update обновление, полученное от Telegram бота.
     */
    public void handle(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().getText() != null) {
                log.debug("Получено текстовое сообщение: {}", update.getMessage().getText());
                handleTextMessage(update.getMessage());
            }
        } catch (Exception e) {
            log.error("Ошибка при обработке обновления: ", e);
        }
    }

    /**
     * Обработка текстовых сообщений.
     *
     * @param message текстовое сообщение, полученное от бота.
     */
    private void handleTextMessage(Message message) {
        var messageText = message.getText();
        var chatId = message.getChatId();

        if (messageText.equals("/start")) {
            handleStartCommand(message, chatId);
        }

        sendInlineKeyboardWithWebApp(chatId);
    }

    /**
     * Обработка команды "/start".
     *
     * @param message сообщение, содержащее команду.
     * @param chatId  ID чата, в котором была произведена команда.
     */
    private void handleStartCommand(Message message, long chatId) {
        var userFirstName = message.getFrom().getFirstName();
        String textForSendMessage;
        textForSendMessage = "Привет " + userFirstName + "!\nМы рады приветствовать тебя в нашем новом боте!";
        log.debug("Обрабатывается команда /start для пользователя: {}", userFirstName);
        messageSender.newMessage()
                .setChatId(chatId)
                .setText(textForSendMessage)
                .send();
    }

    /**
     * Отправка Inline клавиатуры с веб-приложением.
     *
     * @param chatId ID чата, в который необходимо отправить клавиатуру.
     */
    private void sendInlineKeyboardWithWebApp(long chatId) {
        var keyboard = InlineKeyboardAssembler.getInlineKeyboardWithWebApp();
        log.debug("Отправка Inline клавиатуры в чат с ID: {}", chatId);
        messageSender.newMessage()
                .setChatId(chatId)
                .setText("Выберите интересующий для вас раздел")
                .setInlineKeyboard(keyboard)
                .send();
    }
}
