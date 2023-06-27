package com.example.backend.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Http-ответ на запрос создания заказа.
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderResponse extends BaseResponse{
    private String message;

    /**
     * Контруктор создает объект класса {@code OrderResponse} с опеределенным сообщением
     * и кодом ответа.
     *
     * @param   message     подробное сообщение.
     * @param   statusCode  условный код ответа, сообщающий получателю о статусе операции.
     *
     */
    public OrderResponse(int statusCode, String message) {
        super(statusCode);
        this.message = message;
    }
}
