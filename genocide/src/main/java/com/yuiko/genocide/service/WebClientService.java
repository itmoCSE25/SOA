package com.yuiko.genocide.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WebClientService {

    private final RestClient defaultClient = RestClient.create();

    public Integer killByCityId(long id) {


        RestClient customClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://soa-service:8181/soa-service/internal/kill/" + id)
                .build();

        ResponseEntity<Void> response = customClient.get()
                .retrieve()
                .toBodilessEntity();
        return response.getStatusCode().value();
    }

    public Integer deportFromCityToAnother(long fromCityId, long toCityId) {
        RestClient customClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("https://soa-service:8181/soa-service/internal/deport/" + fromCityId + "/" + toCityId)
                .build();

        ResponseEntity<Void> response = customClient.get()
                .retrieve()
                .toBodilessEntity();
        return response.getStatusCode().value();
    }
}
