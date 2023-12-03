package homework.garage.test;

import homework.garage.dao.Garage;
import homework.garage.dao.GarageImpl;
import homework.garage.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GarageImplTest {
    Garage garage;
    List<Car> cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = List.of(
                new Car("Number1", "Model1", "Company1", 1.5, "Red"),
                new Car("Number2", "Model2", "Company1", 2.5, "Green"),
                new Car("Number3", "Model3", "Company2", 1.5, "Red"),
                new Car("Number4", "Model4", "Company2", 2.0, "Green")
        );
        cars.forEach(garage::addCar);
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(cars.get(0)));
        Car car = new Car("Number5", "Model4", "Company2", 2.0, "Green");
        assertTrue(garage.addCar(car));
        car = new Car("Number6", "Model4", "Company2", 2.0, "Green");
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        assertEquals(cars.get(0), garage.removeCar("Number1"));
        assertNull(garage.removeCar("Number1"));
    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("Number4");
        assertEquals(cars.get(3), car); // Проверка по рег. Номеру
        assertEquals(cars.get(3).getColor(), car.getColor());
        assertEquals(cars.get(3).getEngine(), car.getEngine());
        assertEquals(cars.get(3), garage.findCarByRegNumber(new String("Number4")));
    }

    @Test
    void findCarsByModel() {
        List<Car> expected = List.of(cars.get(2));
        List<Car> actual = garage.findCarsByModel("Model3");
        assertIterableEquals(expected, actual);
    }

    @Test
    void findCarsByCompany() {
        List<Car> expected = List.of(cars.get(2), cars.get(3));
        List<Car> actual = garage.findCarsByCompany("Company2");
        assertIterableEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        List<Car> expected = List.of(cars.get(1), cars.get(3));
        List<Car> actual = garage.findCarsByEngine(1.9, 2.6);
        assertIterableEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        List<Car> expected = List.of(cars.get(0), cars.get(2));
        List<Car> actual = garage.findCarsByColor("Red");
        assertIterableEquals(expected, actual);
        assertIterableEquals(List.of(), garage.findCarsByColor("Black"));
    }
}