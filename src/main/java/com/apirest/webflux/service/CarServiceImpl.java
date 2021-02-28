package com.apirest.webflux.service;

import com.apirest.webflux.domain.Car;
import com.apirest.webflux.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    MongoRepository mongoRepository;

    @Override
    public Flux<Car> findAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Mono<Car> findById(String id) {
        return mongoRepository.findById(id);
    }

    @Override
    public Mono<Car> save(Car car) {
        return mongoRepository.save(car);
    }
}
