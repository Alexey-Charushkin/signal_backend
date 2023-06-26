package com.example.backend.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.*;

/**
 * This class represents a Telegram object that can be either a message or a callback query.
 * It provides methods to initialize the object and get its properties.
 */
@Slf4j
public class TelegramObject {

    private BotApiObject botApiObject;
    private boolean isMessage;
    private boolean isCallbackQuery;
    private boolean isContact;
    private Long id;
    private Integer messageId;
    private String text;
    private String data;
    private String userName;
    private User from;
    private Contact contact;
    private String phoneNumber;

    private TelegramObject() {
    }


    /**
     * Initializes the Telegram object based on the given update.
     *
     * @param update the update to initialize the object from
     * @return the initialized Telegram object
     */
    public static TelegramObject getTelegramObject(Update update) {
        TelegramObject telegramObject = new TelegramObject();

        if (isMessageWithText(update)) {
            telegramObject.botApiObject = update.getMessage();
        } else if (isCallbackWithData(update)) {
            telegramObject.botApiObject = update.getCallbackQuery();
        }
        telegramObject.initTelegramObject();

        return telegramObject;
    }


    /**
     * Returns true if the Telegram object is a message, false otherwise.
     *
     * @return true if the Telegram object is a message, false otherwise
     */
    public boolean isMessage() {
        return isMessage;
    }

    /**
     * Returns true if the Telegram object is a callback query, false otherwise.
     *
     * @return true if the Telegram object is a callback query, false otherwise
     */
    public boolean isCallbackQuery() {
        return isCallbackQuery;
    }

    /**
     * Returns the chat ID of the message or callback query.
     *
     * @return the chat ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the message ID of the message or callback query.
     *
     * @return the message ID
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * Returns the text of the message or callback query.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the userName.
     *
     * @return the text
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the data of the callback query.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Returns the user who sent the message or callback query.
     *
     * @return the user
     */
    public User getFrom() {
        return from;
    }

    /**
     * Returns true if the message contains a contact, false otherwise.
     *
     * @return true if the message contains a contact, false otherwise
     */
    public boolean isContact() {
        return isContact;
    }

    /**
     * Returns the phone number of the contact in the message.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the contact in the message.
     *
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Initializes the Telegram object based on the type of the bot API object.
     */
    private void initTelegramObject() {
        isMessage = botApiObject instanceof Message;
        isCallbackQuery = botApiObject instanceof CallbackQuery;

        if (Boolean.TRUE.equals(isMessage)) {
            initMessageObject((Message) botApiObject);
        } else if (Boolean.TRUE.equals(isCallbackQuery)) {
            initCallbackQueryObject((CallbackQuery) botApiObject);
        }
    }

    /**
     * Initializes the message object based on the given message.
     *
     * @param message the message to initialize the object from
     */
    private void initMessageObject(Message message) {
        id = message.getChatId();
        userName = message.getFrom().getUserName();
        messageId = message.getMessageId();
        text = message.getText();
        data = null;
        from = message.getFrom();
        isContact = message.hasContact();
        contact = message.getContact();
        if (Boolean.TRUE.equals(isContact)) {
            phoneNumber = contact.getPhoneNumber();
        }
    }

    /**
     * Initializes the callback query object based on the given callback query.
     *
     * @param callbackQuery the callback query to initialize the object from
     */
    private void initCallbackQueryObject(CallbackQuery callbackQuery) {
        id = callbackQuery.getFrom().getId();
        userName = callbackQuery.getFrom().getUserName();
        messageId = callbackQuery.getMessage().getMessageId();
        text = callbackQuery.getMessage().getText();
        data = callbackQuery.getData();
        from = callbackQuery.getFrom();
        isContact = false;
        contact = null;
        phoneNumber = null;
    }

    private static boolean isMessageWithText(Update update) {
        return !update.hasCallbackQuery() && update.hasMessage();
    }

    private static boolean isCallbackWithData(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        String data = callbackQuery.getData();
        boolean hasData = data != null && !data.isEmpty();

        return update.hasCallbackQuery() && hasData;
    }
}