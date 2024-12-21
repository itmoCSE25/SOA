package com.yuiko.genocide.api;

import java.util.Arrays;

import com.yuiko.genocide.ejb.service.RemoteWebClientService;
import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportController {


    private final RemoteWebClientService remoteWebClientService;
    private static Logger log = Logger.getLogger(DeportController.class);


    public DeportController(RemoteWebClientService remoteWebClientService) {
        this.remoteWebClientService = remoteWebClientService;
    }

    @GetMapping("/deport/{id-from}/{id-to}")
    public ResponseEntity<Void> deportFromCityToAnotherCity(
            @PathVariable("id-from")
            Long idFrom,
            @PathVariable("id-to")
            Long idTo
    ) {
        log.info("Deport from: %d, to: %d".formatted(idFrom, idTo));
        Integer code = 123;
        try {
             code = remoteWebClientService.deportFromCityToAnother(idFrom, idTo);
             log.info("Return code: %d".formatted(code));
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("Code: %d".formatted(code));
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
