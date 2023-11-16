package com.turkcell.order.service.business.abstracts;

import com.turkcell.order.service.dtos.request.CreateCarRequest;
import com.turkcell.order.service.dtos.response.CreatedCarResponse;
import com.turkcell.order.service.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    CreatedCarResponse add (CreateCarRequest request);

    CreatedCarResponse update (String id, CreateCarRequest request);

    Car getByCarId(String carId);

    void deleteCar(String carId);

}

