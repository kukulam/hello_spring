package com.kukulam.springhello.api.time;

import com.kukulam.springhello.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class TimeEndpointTest2 extends IntegrationTest {

    @Test
    void shouldReturnCorrectDateForUTCZone() {
        // given
        String zoneId = "UTC";
        String url = baseUrl() + "/time/now?zoneId=" + zoneId;
        String nowString = "2020-10-10T13:05:01"; // time from TestingUTCClock.now
        TestingTimeResponse expectedResponseBody = new TestingTimeResponse(nowString, zoneId);

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
        String nowString = "2020-10-10T15:05:01"; // time from TestingUTCClock.now
        TestingTimeResponse expectedResponseBody = new TestingTimeResponse(nowString, zoneId);

        // when
        ResponseEntity<TestingTimeResponse> response = restTemplate.getForEntity(url, TestingTimeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }
}