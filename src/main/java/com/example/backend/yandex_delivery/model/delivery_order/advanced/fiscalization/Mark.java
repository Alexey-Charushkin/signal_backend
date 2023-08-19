package com.example.backend.yandex_delivery.model.delivery_order.advanced.fiscalization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mark {
    // Признак маркированности товара Допустимое значение quantity для товара с маркировкой - 1
    @NotNull
    @NotBlank
    private String code; // Значение реквизита товара в соответствии с форматом kind
    @NotNull
    @NotBlank
    private String kind; /* Тип маркировки. Возможные значения:
compiled - уже разобранная марка с выделенным GTIN и Serial. Пример:
444D00000000003741
gs1_data_matrix_base64 - код товара в формате GS1 Data Matrix, подлежащий маркировке средствами идентификации.
 Максимум 200 символов. Код товара необходимо передавать целиком, закодировав строку в формат base64.
 */

}
