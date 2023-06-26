package com.example.backend.telegrambot.keyboards;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class InlineKeyboardMarkupFactory {

    /**
     * Creates a new InlineKeyboardMarkup object with an empty keyboard.
     *
     * @return new InlineKeyboardMarkup object.
     */
    protected static InlineKeyboardMarkup creatNewInlineKeyboard() {
        log.debug("Creating new empty InlineKeyboardMarkup");
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    /**
     * Adds a button to a new line in the given InlineKeyboardMarkup object.
     *
     * @param inlineKeyboardMarkup InlineKeyboardMarkup object to add the button to.
     * @param text Text to display on the button.
     * @param data Callback data associated with the button.
     */
    protected static void addWebAppButtonToNewLine(InlineKeyboardMarkup inlineKeyboardMarkup, String text, String url) {
        log.debug("Adding button to new line: text={}", text);
        var keyboardRoad = getNewKeyboardRoad(inlineKeyboardMarkup);

        InlineKeyboardButton button = new InlineKeyboardButton(text);

        button.setUrl(url);
        keyboardRoad.add(button);
    }

    /**
     * Adds a button to the current line in the given InlineKeyboardMarkup object.
     *
     * @param inlineKeyboardMarkup InlineKeyboardMarkup object to add the button to.
     * @param text Text to display on the button.
     * @param data Callback data associated with the button.
     */
    protected static void addButtonToCurrentLine(InlineKeyboardMarkup inlineKeyboardMarkup, String text, String data) {
        log.debug("Adding button to current line: text={}, data={}", text, data);
        var keyboardRoad = getCurrentKeyboardRoad(inlineKeyboardMarkup);

        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(data);
        keyboardRoad.add(button);
    }

    protected static void addWebAppButtonToCurrentLine(InlineKeyboardMarkup inlineKeyboardMarkup, String text, String data, String url) {
        log.debug("Adding button to current line: text={}, data={}", text, data);
        var keyboardRoad = getCurrentKeyboardRoad(inlineKeyboardMarkup);

        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(data);
        keyboardRoad.add(button);
    }



    /**
     * Gets a new keyboard row for the given InlineKeyboardMarkup object.
     *
     * @param inlineKeyboardMarkup InlineKeyboardMarkup object to get the new row for.
     * @return new keyboard row.
     */
    private static List<InlineKeyboardButton> getNewKeyboardRoad(InlineKeyboardMarkup inlineKeyboardMarkup) {
        log.debug("Getting new keyboard row");
        List<InlineKeyboardButton> keyboardRoad = new ArrayList<>();
        inlineKeyboardMarkup.getKeyboard().add(keyboardRoad);
        return keyboardRoad;
    }

    /**
     * Gets the current keyboard row for the given InlineKeyboardMarkup object.
     *
     * @param inlineKeyboardMarkup InlineKeyboardMarkup object to get the current row for.
     * @return current keyboard row.
     */
    private static List<InlineKeyboardButton> getCurrentKeyboardRoad(InlineKeyboardMarkup inlineKeyboardMarkup) {
        log.debug("Getting current keyboard row");
        var keyboard = inlineKeyboardMarkup.getKeyboard();
        return keyboard.get(keyboard.size() - 1);
    }
}
