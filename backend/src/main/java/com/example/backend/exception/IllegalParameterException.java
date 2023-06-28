package com.example.backend.exception;

/**
 * Сигнализирует о том, что произошло исключение при передаче в метод некорректного аргумента.
 *
 */
import lombok.Getter;

@Getter
public class IllegalParameterException extends RuntimeException {
    private final int statusCode;

    /**
     * Контруктор создает объект класса {@code IllegalParameterException} с опеределенным сообщением
     * и кодом ответа.
     *
     * @param   message     подробное сообщение.
     * @param   statusCode  условный код ответа, сообщающий получателю о статусе операции.
     *
     */
    public IllegalParameterException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
