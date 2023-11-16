package com.turkcell.order.service.business.concrets;

import com.turkcell.order.service.business.abstracts.CarService;
import com.turkcell.order.service.dtos.request.CreateCarRequest;
import com.turkcell.order.service.dtos.response.CreatedCarResponse;
import com.turkcell.order.service.entities.Car;
import com.turkcell.order.service.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() {     // Requestlere build edilecek yapamadık ???
        return carRepository.findAll();
    }

    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = Car
                .builder()
                .brand(request.getBrand())
                .colorOfCar(request.getColorOfCar())
                .model(request.getModel())
                .yearOfManufacture(request.getYearOfManufacture())
                .dailyPrice(request.getDailyPrice())
                .picture(request.isPicture())
                .build();
        car = carRepository.save(car);
        CreatedCarResponse response = CreatedCarResponse
                .builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .build();
        return response;
    }

    @Override
    public CreatedCarResponse update(String id, CreateCarRequest request) {
        Car car = carRepository.findById(id).orElseThrow();

        car.setBrand(request.getBrand());
        car.setColorOfCar(request.getColorOfCar());
        car.setModel(request.getModel());
        car.setYearOfManufacture(request.getYearOfManufacture());
        car.setDailyPrice(request.getDailyPrice());
        car.setPicture(request.isPicture());

        carRepository.save(car);

        CreatedCarResponse response = CreatedCarResponse
                .builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .build();

        return response;
    }

    @Override
    public Car getByCarId(String carId) {
        return carRepository.findById(carId).get();

    }

    @Override
    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }
}

