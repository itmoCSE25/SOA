package com.yuiko.genocide.api;

import com.yuiko.soa.api.UtilityApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController implements UtilityApi {

    @Override
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("0;OK");
    }
}
