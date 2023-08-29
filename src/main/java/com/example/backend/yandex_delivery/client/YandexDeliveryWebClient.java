package com.example.backend.yandex_delivery.client;

import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortRequestDeliveryOrderDto;
import com.example.backend.yandex_delivery.model.delivery_order.dto.ShortResponseDeliveryOrderDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
//@RequiredArgsConstructor
public class YandexDeliveryWebClient {
    WebClient webClient = WebClient.create();
    private final String baseUri = "https://b2b.taxi.yandex.net/b2b/cargo/integration/v2/claims/";
    private final String requestId = "904359043";

    public Mono<ShortResponseDeliveryOrderDto> saveDeliveryOrder(String path, ShortRequestDeliveryOrderDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_LANGUAGE, "ru/ru");

        String url = UriComponentsBuilder.fromHttpUrl(baseUri + path)
                .queryParam("request_id", requestId)
                .toUriString();

        return webClient
                .method(HttpMethod.POST)
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, response -> {
//                    System.out.println("Ошибка клиента: " + response.statusCode());
//                    return response.createException().flatMap(Mono::error);
//                })
                .toEntity(ShortResponseDeliveryOrderDto.class)
                .mapNotNull(responseEntity -> {
                    System.out.println("Статус код: " + responseEntity.getStatusCode());
                    System.out.println("Ответ: " + responseEntity.getBody());
                    return responseEntity.getBody();
                });
    }


/*
    public List<StatsDtoToReturn> getStatistics(StatsDtoToGetStats statsParameters) {
        String endpointPath = "/stats";

        String url = UriComponentsBuilder.fromHttpUrl(baseUri + endpointPath)
                .queryParam("start", statsParameters.getStart())
                .queryParam("end", statsParameters.getEnd())
                .queryParam("uris", statsParameters.getUris())
                .queryParam("unique", statsParameters.isUnique())
                .queryParam("from", statsParameters.getFrom())
                .queryParam("size", statsParameters.getSize())
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(StatsDtoToReturn.class)
                .collectList()
                .block();
    }

 */
}
