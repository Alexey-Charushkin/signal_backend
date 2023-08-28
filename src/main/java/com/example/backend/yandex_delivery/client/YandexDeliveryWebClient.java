package com.example.backend.yandex_delivery.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

public class YandexDeliveryWebClient {
    WebClient webClient = WebClient.create();

    String baseUri = "b2b.taxi.yandex.net/b2b/cargo/integration/v2/claims/"; // используеться для приложения развёрнутого в docker контейнере
    // String uri = "http://localhost:9090"; // используется для приложения развёрнутого без docker

    UUID uuid = UUID.randomUUID();

    String path = "create\\?request_id={" + uuid + "}";


    public void saveDeliveryOrder(String path, StatsDtoToSave statsDtoToSave) {
        webClient
                .method(HttpMethod.POST)
                .uri(baseUri + path)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(statsDtoToSave))
                .retrieve()
                .toEntity(String.class)
                .subscribe(responseEntity -> {
                    System.out.println("Статус код: " + responseEntity.getStatusCode());
                    System.out.println("Ответ: " + responseEntity.getBody());
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
