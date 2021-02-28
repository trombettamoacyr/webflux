package com.apirest.webflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car")
@Data
public class Car {

    @Id
    private String id;

    private String model;

}