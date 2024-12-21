package com.yuiko.genocide.api;

import com.yuiko.genocide.ejb.service.RemoteWebClientService;
import com.yuiko.genocide.service.WebClientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KillController {


    private final RemoteWebClientService remoteWebClientService;

    public KillController(RemoteWebClientService remoteWebClientService) {
        this.remoteWebClientService = remoteWebClientService;
    }

    @GetMapping("kill/{id}")
    public ResponseEntity<Void> killAllInCityById(
            @PathVariable("id")
            Long id
    ) {
        Integer code = remoteWebClientService.killByCityId(id);
        if (code == 200) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
