package com.example.backend.telegrambot.messagesenders;

import com.example.backend.telegrambot.TelegramBotApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public abstract class MessageSender {
    private TelegramBotApplication telegramBot;
    private SendMessage sendMessage;

    @Autowired
    protected MessageSender(TelegramBotApplication telegramBot) {
        this.telegramBot = telegramBot;
        this.sendMessage = new SendMessage();
    }

    /**
     * Sends a message with the specified text and message ID to reply to.
     *
     * @param text      the text of the message
     * @param messageId the ID of the message to reply to
     * @return the message that was sent
     */
    protected Message sendMessage(String text, Integer messageId) {
        sendMessage.setReplyToMessageId(messageId);
        return sendMessage(text);
    }

    /**
     * Sends a message with the specified text.
     *
     * @param text the text of the message
     * @return the message that was sent
     */
    protected Message sendMessage(String text) {
        sendMessage.setText(text);

        log.debug("Preparing to send message with chat ID: {}, text: {}", sendMessage.getChatId(), sendMessage.getText());
        return executeMessage();
    }

    protected void setText (String text) {
        sendMessage.setText(text);
    }

    /**
     * Sends the message using the Telegram Bot API.
     *
     * @return the message that was sent
     */
    protected Message executeMessage() {
        sendMessage.enableMarkdown(true);
        sendMessage.enableHtml(true);

        log.debug("Sending message with chat ID: {}, text: {}", sendMessage.getChatId(), sendMessage.getText());

        Message message = null;
        try {
            message = telegramBot.execute(sendMessage);
            log.debug("Successfully sent message to chat ID: {}, with message ID: {}", message.getChatId(), message.getMessageId());
        } catch (TelegramApiException e) {
            log.debug("Error sending message to user: {}", e.getMessage());
            e.printStackTrace();
        }

        return message;
    }

    /**
     * Creates a new SendMessage object.
     */
    protected void newSendMessage() {
        sendMessage = new SendMessage();
    }

    /**
     * Gets the current SendMessage object.
     *
     * @return the current SendMessage object
     */
    protected SendMessage getSendMessage() {
        return sendMessage;
    }
}
