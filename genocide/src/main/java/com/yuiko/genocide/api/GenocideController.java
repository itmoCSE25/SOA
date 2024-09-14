package com.yuiko.genocide.api;

import com.yuiko.soa.api.GenocideApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenocideController implements GenocideApi {

    @Override
    public ResponseEntity<Void> deportFromCityToAnotherCity(Long idFrom, Long idTo) {
        return GenocideApi.super.deportFromCityToAnotherCity(idFrom, idTo);
    }

    @Override
    public ResponseEntity<Void> killAllInCityById(Long id) {
        return GenocideApi.super.killAllInCityById(id);
    }
}
