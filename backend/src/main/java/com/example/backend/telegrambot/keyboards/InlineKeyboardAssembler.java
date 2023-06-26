package com.example.backend.telegrambot.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class InlineKeyboardAssembler extends InlineKeyboardMarkupFactory{

    public static InlineKeyboardMarkup getInlineKeyboardWithWebApp () {
        var keyboard = creatNewInlineKeyboard();

        addWebAppButtonToNewLine(keyboard, "Test webAppButton", "https://chromedino.com/");

        return keyboard;
    }
}
