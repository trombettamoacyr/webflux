package com.apirest.webflux.controller;

import com.apirest.webflux.domain.Car;
import com.apirest.webflux.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value="/cars")
    public Flux<Car> getCar(){
        return carService.findAll();
    }

    @GetMapping(value="/car/{id}")
    public Mono<Car> getCarById(@PathVariable String id) {
        return carService.findById(id);
    }

    @PostMapping(value="/car/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> saveNewCar(@RequestBody Car car) {
        return carService.save(car);
    }
}
