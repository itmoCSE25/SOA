package com.yuiko.genocide.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class WebClientService {

    public Integer killByCityId(long id) {
        try (Client client = ClientBuilder.newBuilder().hostnameVerifier((hostname, session) -> true).build()) {

            Response response = client
                    .target("https://soa-service:8181/soa-service/internal/kill/" + id)
                    .request(MediaType.APPLICATION_XML_TYPE)
                    .get();

            return response.getStatus();

        }
    }

    public Integer deportFromCityToAnother(long fromCityId, long toCityId) {
        try (Client client = ClientBuilder.newBuilder().hostnameVerifier((hostname, session) -> true).build()) {

            Response response = client
                    .target("https://soa-service:8181/soa-service/internal/deport/" + fromCityId + "/" + toCityId)
                    .request(MediaType.APPLICATION_XML_TYPE)
                    .get();

            return response.getStatus();
        }
    }
}
