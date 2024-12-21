package com.yuiko.genocide.api;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private static Logger log = Logger.getLogger(PingController.class);

    public PingController() {

    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        log.info("ping");
        return ResponseEntity.ok("genocide pong\n");
    }
}
