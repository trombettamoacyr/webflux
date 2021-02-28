package com.apirest.webflux;

import com.apirest.webflux.domain.Car;
import com.apirest.webflux.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


//@Component
public class CarHandler {

    @Autowired
    CarService carService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(carService.findAll(), Car.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(carService.findById(id), Car.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Car> car = request.bodyToMono(Car.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(car.flatMap(carService::save), Car.class));
    }

}
