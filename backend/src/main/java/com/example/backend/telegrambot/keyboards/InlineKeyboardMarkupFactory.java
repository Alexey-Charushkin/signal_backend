package com.example.backend.telegrambot.keyboards;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

/**

 Фабрика для создания InlineKeyboardMarkup.
 */
@Slf4j
public abstract class InlineKeyboardMarkupFactory {


    /**

     Создает новую пустую InlineKeyboardMarkup.

     @return пустая InlineKeyboardMarkup.
     */
    protected static InlineKeyboardMarkup creatNewInlineKeyboard() {
        log.debug("Создание новой пустой InlineKeyboardMarkup");
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    /**

     Добавляет кнопку веб-приложения в новую строку InlineKeyboardMarkup.

     @param inlineKeyboardMarkup InlineKeyboardMarkup, в которую добавляется кнопка.

     @param text Текст кнопки.

     @param url URL веб-приложения.
     */
    protected static void addWebAppButtonToNewLine(InlineKeyboardMarkup inlineKeyboardMarkup, String text, String url) {
        log.debug("Добавление кнопки в новую строку: текст={}", text);
        var keyboardRoad = getNewKeyboardRoad(inlineKeyboardMarkup);

        InlineKeyboardButton button = new InlineKeyboardButton(text);

        var webApp = WebAppInfo.builder().url(url).build();
        log.debug(webApp.toString());
        button.setWebApp(webApp);
        keyboardRoad.add(button);
    }

    /**

     Добавляет кнопку, при нажатии на которую пользователь сможет выбрать контакты, которым будет отправлено приглашение в бот, в новую строку InlineKeyboardMarkup.

     @param inlineKeyboardMarkup InlineKeyboardMarkup, в которую добавляется кнопка.

     @param text Текст кнопки.

     @param invitationMessage Сообщение-приглашение в бот, которое будет отправлено выбранным контактам.
     */
    protected static void addSwitchButtonToNewLine (InlineKeyboardMarkup inlineKeyboardMarkup, String text, String invitationMessage) {
        log.debug("Добавление кнопки в новую строку: текст={}", text);
        var keyboardRoad = getNewKeyboardRoad(inlineKeyboardMarkup);

        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setSwitchInlineQuery(invitationMessage);

        keyboardRoad.add(button);
    }

    /**

     Получает новую строку клавиатуры для InlineKeyboardMarkup.
     @param inlineKeyboardMarkup InlineKeyboardMarkup, для которого нужна новая строка клавиатуры.
     @return Новая строка клавиатуры.
     */
    private static List<InlineKeyboardButton> getNewKeyboardRoad(InlineKeyboardMarkup inlineKeyboardMarkup) {
        log.debug("Получение новой строки клавиатуры");
        List<InlineKeyboardButton> keyboardRoad = new ArrayList<>();
        inlineKeyboardMarkup.getKeyboard().add(keyboardRoad);
        return keyboardRoad;
    }
}