package com.example.backend.yandex_delivery.client;

import com.example.backend.yandex_delivery.exceptions.WebClientException;
import com.example.backend.yandex_delivery.model.delivery_order.dto.AcceptDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.CancelDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortRequestInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YandexDeliveryWebClient {
    private final WebClient webClient = WebClient.create();
    private HttpHeaders headers;
    private final String baseUri = "https://b2b.taxi.yandex.net/b2b/cargo/integration/v2";

    public Mono<Object> getInitialCost(String path, ShortRequestInitialCostEstimateDto dto) {
        return sendRequest(path, dto);
    }

    public Mono<Object> saveDeliveryOrder(String path, ShortRequestDeliveryOrderDto dto) {
        return sendRequest(path, dto);
    }

    public Mono<Object> getDeliveryOrder(String path) {
        return sendRequest(path, null);
    }

    public Mono<Object> cancelDeliveryOrder(String path, CancelDto dto) {
        return sendRequest(path, dto);
    }

    // К этому запросу относитесь аккуратно. Можно вызвать курьера.
    public Mono<Object> acceptDeliveryOrder(String path, AcceptDto dto) {
        return sendRequest(path, dto);
    }

    private Mono<Object> sendRequest(String path, Object dto) {
        WebClient.RequestBodySpec request = webClient
                .method(HttpMethod.POST)
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(getHeaders()));

        if (dto != null) {
            request = (WebClient.RequestBodySpec) request.body(BodyInserters.fromValue(dto));
        }

        return request
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                            WebClientException exception = new WebClientException(" client error: " + errorBody);
                            return Mono.error(exception);
                        }))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                            WebClientException exception = new WebClientException(" server error: " + errorBody);
                            return Mono.error(exception);
                        }))
                .toEntity(ShortResponseDeliveryOrderDto.class)
                .mapNotNull(responseEntity -> {
                    System.out.println("Статус код: " + responseEntity.getStatusCode());
                    System.out.println("Ответ: " + responseEntity.getBody());
                    return responseEntity.getBody();
                });
    }

    private HttpHeaders getHeaders() {
        // токен авторизации
        String oauth_token = "y0_AgAAAABwgIQFAAc6MQAAAADsGlYZaLKi7oBkQTaPzQ9FNu5hCavMXhs";

        if (headers != null) return headers;

        headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.setBearerAuth(oauth_token);
        return headers;
    }
}
