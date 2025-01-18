package com.yuiko.genocide_soap.service;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteWebClientServiceImpl implements RemoteWebClientService {

    private final RestTemplate restTemplate;

    private final String defaultUrl = "https://soa-haproxy:8080/internal/";

    public RemoteWebClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Integer killByCityId(long id) {
        String url = "%s/kill/%d".formatted(defaultUrl, id);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
        return response.getStatusCode().value();
    }

    @Override
    public Integer deportFromCityToAnother(long fromCityId, long toCityId) {
        String url = "%s/deport/%d/%d".formatted(defaultUrl, fromCityId, toCityId);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
        return response.getStatusCode().value();
    }
}
