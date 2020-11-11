package com.kukulam.springhello.api.hello;

import com.kukulam.springhello.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class HelloEndpointTest extends IntegrationTest {

    @Test
    void shouldReturnCorrectHelloMessage() {
        // given
        String name = "Billy";
        String url = baseUrl() + "/hello?name=" + name;
        TestingHelloResponse expectedResponseBody = new TestingHelloResponse("Hello " + name);

        // when
        ResponseEntity<TestingHelloResponse> response = restTemplate.getForEntity(url, TestingHelloResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponseBody);
    }
}