package com.yuiko.genocide.api;

import com.yuiko.soa.api.UtilityApi;
import jakarta.ws.rs.core.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class PingController implements UtilityApi {

    private final WebClient webClient;

    public PingController(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public ResponseEntity<String> ping() {
        String result = webClient.get()
                .uri("/ping")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return ResponseEntity.ok(result);
    }
}
