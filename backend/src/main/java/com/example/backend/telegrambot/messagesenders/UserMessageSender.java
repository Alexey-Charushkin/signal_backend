package com.example.backend.telegrambot.messagesenders;

import com.example.backend.telegrambot.TelegramBotApplication;
import com.example.backend.telegrambot.TelegramObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;


/**
 * This class is responsible for sending messages via the Telegram Bot API.
 */
@Slf4j
@Component
public class UserMessageSender extends MessageSender {
    private TelegramObject telegramObject;

    @Autowired
    public UserMessageSender(TelegramBotApplication telegramBot) {
        super(telegramBot);
    }

    /**
     * Sends a message with the specified text to the user.
     *
     * @param text the text of the message
     * @return the message that was sent
     */
    public Message sendMessage(String text) {
        getSendMessage().setChatId(telegramObject.getId());

        return super.sendMessage(text);
    }

    public Message sendMessageWithInlineKeyboard (String text, InlineKeyboardMarkup keyboard){
        getSendMessage().setChatId(telegramObject.getId());
        getSendMessage().setReplyMarkup(keyboard);

        return super.sendMessage(text);
    }


    public void clean(TelegramObject telegramObject) {
        this.telegramObject = telegramObject;
        newSendMessage();
    }
}
