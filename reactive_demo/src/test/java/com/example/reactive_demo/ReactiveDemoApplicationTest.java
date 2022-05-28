package com.example.reactive_demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactiveDemoApplicationTest {

    WebTestClient webTestClient;

    @Autowired
    ReactiveDemoApplicationTest(
            WebTestClient webTestClient
    ) {
        this.webTestClient = webTestClient;
    }

    @Test
    public void testHello() {
        webTestClient.get().uri("/hello").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk().expectBody(Greeting.class).value(greeting -> {
            assert (Objects.equals(greeting.getMessage(), "Hello, Spring!"));
        });
    }

}
