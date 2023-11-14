package com.turkcell.order.service.repositories;

import com.turkcell.order.service.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,Integer> {

}
