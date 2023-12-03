package homework.garage.dao;

import homework.garage.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class GarageImpl implements Garage {
    private List<Car> cars;
    private int capacity;

    public GarageImpl(int capacity) {
        this.capacity = capacity;
        cars = new ArrayList<>(capacity);
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || cars.size() == capacity || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars.add(car);
        return true;
    }


    @Override
    public Car removeCar(String regNumber) {
        Car removedCar = findCarByRegNumber(regNumber);
        if (removedCar != null) {
            cars.remove(removedCar);
        }
        return removedCar;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        return cars.stream()
                .filter(c -> c.getRegNumber().equals(regNumber))
                .findFirst()
                .orElse(null);
    }

    public List<Car> findCarsByModel(String model) {
        return filterCars(c -> c.getModel().equals(model));
    }

    @Override
    public List<Car> findCarsByCompany(String company) {
        return filterCars(c -> c.getCompany().equals(company));
    }

    @Override
    public List<Car> findCarsByEngine(double min, double max) {
        return filterCars(c -> c.getEngine() >= min && c.getEngine() < max);
    }

    @Override
    public List<Car> findCarsByColor(String color) {
        return filterCars(c -> c.getColor().equals(color));
    }

    private List<Car> filterCars(Predicate<Car> predicate) {
        return cars.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
