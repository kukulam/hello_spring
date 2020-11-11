package com.kukulam.springhello.api.time;

import com.kukulam.springhello.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Clock;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TimeEndpointTest extends IntegrationTest {

    @MockBean
    private Clock clock;

    @Test
    void shouldReturnCorrectDateForUTCZone() {
        // given
        String zoneId = "UTC";
        String url = baseUrl() + "/time/now?zoneId=" + zoneId;
        Instant nowInstant = Instant.ofEpochMilli(1605106801000L);
        String nowString = "2020-11-11T15:00:01";
        TestingTimeResponse expectedResponseBody = new TestingTimeResponse(nowString, zoneId);

        when(clock.instant()).thenReturn(nowInstant);

        // when
        ResponseEntity<TestingTimeResponse> response = restTemplate.getForEntity(url, TestingTimeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }

    @Test
    void shouldReturnCorrectDateForPolishZone() {
        // given
        String zoneId = "Europe/Warsaw";
        String url = baseUrl() + "/time/now?zoneId=" + zoneId;
        Instant nowInstant = Instant.ofEpochMilli(1605106801000L);
        String nowString = "2020-11-11T16:00:01";
        TestingTimeResponse expectedResponseBody = new TestingTimeResponse(nowString, zoneId);

        when(clock.instant()).thenReturn(nowInstant);

        // when
        ResponseEntity<TestingTimeResponse> response = restTemplate.getForEntity(url, TestingTimeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }

    @Test
    void shouldReturnUnprocessableEntityForIncorrectZone() {
        // given
        String zoneId = "Unknown/zone";
        String url = baseUrl() + "/time/now?zoneId=" + zoneId;

        // when
        assertThrows(HttpClientErrorException.UnprocessableEntity.class, () -> restTemplate.getForEntity(url, TestingTimeResponse.class));
    }
}