package com.example.reactive_demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GreetingClient {
    /**
     * Web client is just something used to call http.
     */
    private final WebClient client;

    public GreetingClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    /**
     * bodyToMono = turn the body into element.
     */
    public Mono<String> getMessage() {
        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }
}
