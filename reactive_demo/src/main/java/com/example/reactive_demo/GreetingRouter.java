package com.example.reactive_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * This is a functional way.
 * <p>
 * Annotated way is a lil diff.
 */
@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
    }

    @Bean
    public void stuff() {
        System.out.println("This thing runs cus @Bean");
    }
}
