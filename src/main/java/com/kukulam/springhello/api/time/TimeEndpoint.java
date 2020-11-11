package com.kukulam.springhello.api.time;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;

@RestController
public class TimeEndpoint {

    private final Clock clock;

    public TimeEndpoint(Clock clock) {
        this.clock = clock;
    }

    @GetMapping("/time/now")
    public ResponseEntity<TimeResponse> now(@RequestParam String zoneId) {
        try {
            String localTime = clock.instant()
                    .atZone(ZoneId.of(zoneId))
                    .toLocalDateTime()
                    .toString();
            TimeResponse timeResponse = new TimeResponse(localTime, zoneId);
            return ResponseEntity.ok(timeResponse);
        } catch (ZoneRulesException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}

