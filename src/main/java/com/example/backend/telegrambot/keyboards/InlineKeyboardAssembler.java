package com.example.backend.telegrambot.keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Класс-сборщик Inline-клавиатуры.
 */
public class InlineKeyboardAssembler extends InlineKeyboardMarkupFactory {

    private InlineKeyboardAssembler() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Создает Inline-клавиатуру с веб-приложением.
     *
     * @return собранная Inline-клавиатура с веб-приложением.
     */
    public static InlineKeyboardMarkup getInlineKeyboardWithWebApp () {
        var keyboard = creatNewInlineKeyboard();

        addWebAppButtonToNewLine(keyboard, "\uD83D\uDDC2 Меню", "https://chromedino.com/");
        addWebAppButtonToNewLine(keyboard, "\uD83D\uDE0A Профиль", "https://chromedino.com/");
        addWebAppButtonToNewLine(keyboard, "\uD83D\uDCCB Мои заказы", "https://chromedino.com/");
        addWebAppButtonToNewLine(keyboard, "\uD83D\uDCCD Наши контакты", "https://chromedino.com/");
        addSwitchButtonToNewLine(keyboard, "\uD83D\uDE4D Пригласить друга", "Приглашаю тебя в телеграмм-бот отличного кафе");
        //Нужно будет отпредактивровать данный текст.
        // Данный текст отправится пользователю вместе с ссылкой на наш телеграмм бот.

        return keyboard;
    }
}
