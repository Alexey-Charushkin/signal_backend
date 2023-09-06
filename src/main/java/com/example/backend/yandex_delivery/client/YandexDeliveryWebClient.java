package com.example.backend.yandex_delivery.client;

import com.example.backend.yandex_delivery.model.delivery_order.dto.AcceptDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.CancelDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YandexDeliveryWebClient {
    WebClient webClient = WebClient.create();
    private final String baseUri = "https://b2b.taxi.yandex.net";
    private final String oauthToken = "904359043"; // токен авторизации

    public Mono<ShortResponseDeliveryOrderDto> saveDeliveryOrder(String path, ShortRequestDeliveryOrderDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");
        headers.setBearerAuth(oauthToken);


        return webClient
                .method(HttpMethod.POST)
                .uri(baseUri + path)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
                .onStatus(response -> response.is4xxClientError(), response -> {
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
        headers.setBearerAuth(oauthToken);

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
        headers.setBearerAuth(oauthToken);

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
