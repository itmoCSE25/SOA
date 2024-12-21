package com.yuiko.genocide.ejb.service;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.jboss.ejb3.annotation.Pool;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Stateless(name = "RemoteWebClientService")
@Pool("web-client-service-pool")
public class RemoteWebClientServiceImpl implements RemoteWebClientService {

    @Inject
    private RestTemplate restTemplate;

    private final String defaultUrl = "http://soa-haproxy:8080/internal/";

    @Override
    public Integer killByCityId(long id) {
        log.info("killByCityId: {}", id);
        String url = "%s/kill/%d".formatted(defaultUrl, id);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
        return response.getStatusCode().value();
    }

    @Override
    public Integer deportFromCityToAnother(long fromCityId, long toCityId) {
        log.info("deportFromCityToAnother: {} -> {}", fromCityId, toCityId);
        String url = "%s/deport/%d/%d".formatted(defaultUrl, fromCityId, toCityId);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
        return response.getStatusCode().value();
    }
}
