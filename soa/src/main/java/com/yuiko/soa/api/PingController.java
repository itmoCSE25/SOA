package com.yuiko.soa.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController implements UtilityApiDelegate {

    @Override
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
