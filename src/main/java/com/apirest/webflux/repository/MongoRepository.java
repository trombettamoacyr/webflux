package com.apirest.webflux.repository;

import com.apirest.webflux.domain.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepository extends ReactiveMongoRepository<Car, String> {

}
