package com.example.backend.yandex_delivery.client;

import com.example.backend.yandex_delivery.model.delivery_order.dto.CancelDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortRequestInitialCostEstimateDto;
import com.example.backend.yandex_delivery.model.initial_cost_estimate.dto.ShortResponseInitialCostEstimateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YandexDeliveryWebClient {
    private final WebClient webClient = WebClient.create();
    private final String baseUri = "https://b2b.taxi.yandex.net";
    private final String OAUTH_TOKEN = "y0_AgAAAABwgIQFAAc6MQAAAADsGlYZaLKi7oBkQTaPzQ9FNu5hCavMXhs"; // токен авторизации

    public ShortResponseInitialCostEstimateDto getInitialCost(String path, ShortRequestInitialCostEstimateDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.setBearerAuth(OAUTH_TOKEN);

        return webClient
                .post()
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    System.out.println("Client error:  " + response.statusCode());
                    return response.createException().flatMap(Mono::error);
                })
                .bodyToMono(ShortResponseInitialCostEstimateDto.class)
                .block();
    }

    public Mono<ShortResponseDeliveryOrderDto> saveDeliveryOrder(String path, ShortRequestDeliveryOrderDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.setBearerAuth(OAUTH_TOKEN);

        return webClient
                .method(HttpMethod.POST)
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    System.out.println("Client error:  " + response.statusCode());
                    return response.createException().flatMap(Mono::error);
                })
                .toEntity(ShortResponseDeliveryOrderDto.class)
                .mapNotNull(responseEntity -> {
                    System.out.println("Статус код: " + responseEntity.getStatusCode());
                    System.out.println("Ответ: " + responseEntity.getBody());
                    return responseEntity.getBody();
                });
    }

    public ShortResponseDeliveryOrderDto getDeliveryOrder(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.setBearerAuth(OAUTH_TOKEN);

        return webClient.post()
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ShortResponseDeliveryOrderDto.class)
                .block();
    }

    public ShortResponseDeliveryOrderDto cancelDeliveryOrder(String path, CancelDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.setBearerAuth(OAUTH_TOKEN);

        return webClient.post()
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .bodyToMono(ShortResponseDeliveryOrderDto.class)
                .block();
    }

// К этому запросу относитесь аккуратно. Можно вызвать курьера.

//    public ShortResponseDeliveryOrderDto acceptDeliveryOrder(String path, AcceptDto dto) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
//        headers.setBearerAuth(oauthToken);
//
//        return webClient.post()
//                .uri(baseUri + path)
//                .headers(httpHeaders -> httpHeaders.addAll(headers))
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(dto))
//                .retrieve()
//                .bodyToMono(ShortResponseDeliveryOrderDto.class)
//                .block();
//    }
}
