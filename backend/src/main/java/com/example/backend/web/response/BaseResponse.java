package com.example.backend.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Стандартный http-ответ. Данный класс является общим для всех остальных http-ответов,
 * которые должны наследоваться от него.
 */

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {
    private int statusCode;

    /**
     * Конструктор создает объект класса {@code BaseResponse} с опеределенным кодом ответа.
     *
     * @param   statusCode  условный код ответа, сообщающий получателю о статусе операции.
     *
     */
    public BaseResponse(int statusCode) {
        this.statusCode = statusCode;
    }
}