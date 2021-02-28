package com.apirest.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CarRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(CarHandler handler) {
        return RouterFunctions
                .route(GET("/cars").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/car/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/save").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }

}
