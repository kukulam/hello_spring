package com.kukulam.springhello.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Profile("integration")
@Configuration
public class TestingUTCClock {

    // UTC 2020-10-10 13:05:01
    public static Instant now = Instant.ofEpochMilli(1602335101000L);

    @Bean
    Clock testingClock() {
        return Clock.fixed(now, ZoneId.of("UTC"));
    }
}
