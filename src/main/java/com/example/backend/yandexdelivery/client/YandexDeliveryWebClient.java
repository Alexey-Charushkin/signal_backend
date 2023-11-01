package com.example.backend.yandexdelivery.client;

import com.example.backend.yandexdelivery.exceptions.WebClientException;
import com.example.backend.yandexdelivery.model.deliveryorder.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandexdelivery.model.initialcostestimate.dto.ShortResponseInitialCostEstimateDto;
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

    public <T> Mono<ShortResponseInitialCostEstimateDto> getInitialCost(String path, T dto) {
        return sendRequest(path, dto, ShortResponseInitialCostEstimateDto.class);
    }

    public <T> Mono<ShortResponseDeliveryOrderDto> saveDeliveryOrder(String path, T dto) {
        return sendRequest(path, dto, ShortResponseDeliveryOrderDto.class);
    }

    public Mono<ShortResponseDeliveryOrderDto> getDeliveryOrder(String path) {
        return sendRequest(path, null, ShortResponseDeliveryOrderDto.class);
    }

    public <T> Mono<ShortResponseDeliveryOrderDto> cancelDeliveryOrder(String path, T dto) {
        return sendRequest(path, dto, ShortResponseDeliveryOrderDto.class);
    }

    // К этому запросу относитесь аккуратно. Можно вызвать курьера.
    public <T> Mono<ShortResponseDeliveryOrderDto> acceptDeliveryOrder(String path, T dto) {
        return sendRequest(path, dto, ShortResponseDeliveryOrderDto.class);
    }

    private <T, R> Mono<R> sendRequest(String path, T dto, Class<R> responseType) {

        String baseUri = "https://b2b.taxi.yandex.net/b2b/cargo/integration/v2";

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
                .toEntity(responseType)
                .mapNotNull(responseEntity -> {
                    System.out.println("Статус код: " + responseEntity.getStatusCode());
                    System.out.println("Ответ: " + responseEntity.getBody());
                    return responseEntity.getBody();
                });
    }

    private HttpHeaders getHeaders() {

        if (headers != null) return headers;

        String oauth_token = "y0_AgAAAABwgIQFAAc6MQAAAADsGlYZaLKi7oBkQTaPzQ9FNu5hCavMXhs"; // токен авторизации

        headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.setBearerAuth(oauth_token);
        return headers;
    }
}
