package com.example.backend.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Стандартный http-ответ на запросы, которые завершились ошибкой. Данный класс используется глобальным
 * обработчиком исключений {@code GlobalExceptionHandler},
 * и направляется отпрвителю запроса, в случае возникновения исключения.
 */
@Getter
@Setter
@NoArgsConstructor
public class FailedResponse extends BaseResponse {
    private String errorMessage;

    /**
     * Контруктор создает объект класса {@code FailedResponse} с опеределенным сообщением
     * и кодом ответа.
     *
     * @param   errorMessage    подробное сообщение об ошибке.
     * @param   statusCode      условный код ответа, сообщающий получателю о статусе операции.
     *
     */
    public FailedResponse(int statusCode, String errorMessage) {
        super(statusCode);
        this.errorMessage = errorMessage;
    }

}
