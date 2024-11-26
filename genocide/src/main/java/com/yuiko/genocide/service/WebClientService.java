package com.yuiko.genocide.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class WebClientService {

    public String killByCityId(long id) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target("http://localhost:8080/soa-service/internal/kill/" + id);
            String result = target.request(MediaType.APPLICATION_XML_TYPE).get(String.class);
            return result;
        }
    }

    public String deportFromCityToAnother(long fromCityId, long toCityId) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target("http://localhost:8080/soa-service/internal/deport/" + fromCityId + "/" + toCityId);
            String result = target.request(MediaType.APPLICATION_XML_TYPE).get(String.class);
            return result;
        }
    }
}
