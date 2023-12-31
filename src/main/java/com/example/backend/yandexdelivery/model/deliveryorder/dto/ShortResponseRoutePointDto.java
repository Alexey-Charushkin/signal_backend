package com.example.backend.yandexdelivery.model.deliveryorder.dto;

import com.example.backend.yandexdelivery.model.deliveryorder.base.route_point.base.VisitedAt;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortResponseRoutePointDto {
    @NotNull
    private ShortAddressDto address;
    @NotNull
    private ShortContactDto contact;
    @NotNull
    private long id;
    @NotNull
    private String type;
    @NotNull
    private int visit_order;
    @NotNull
    private String visit_status;
    @NotNull
    private VisitedAt visited_at;
    @NotNull
    private ExternalOrderCostDto external_order_cost;

    public String getVisitStatus() {
        return visit_status;
    }
}
