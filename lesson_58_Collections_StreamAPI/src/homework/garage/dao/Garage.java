package homework.garage.dao;

import homework.garage.model.Car;

import java.util.List;

public interface Garage {
    boolean addCar(Car car);

    Car removeCar(String regNumber);

    Car findCarByRegNumber(String regNumber);

    List<Car> findCarsByModel(String model);

    List<Car> findCarsByCompany(String company);

    List<Car> findCarsByEngine(double min, double max);

    List<Car> findCarsByColor(String color);
}
