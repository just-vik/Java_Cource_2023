package practice.employee_save_read;

import java.io.Serializable;

public class Address implements Serializable {
    //Интерфейс Serializable в Java используется для обозначения классов, объекты которых могут быть сериализованы.
    //Сериализация - это процесс преобразования объекта в последовательность байтов, которые могут быть сохранены в файле или переданы по сети,
    //а затем восстановлены обратно в объект. Это полезно, например,
    //для сохранения состояния объекта или передачи объекта между разными частями программы или между приложениями.
    private String city;
    private String street;
    private int building;
    private int aprt;

    public Address(String city, String street, int building, int aprt) {
        System.out.println("Constructor Address is working...");
        this.city = city;
        this.street = street;
        this.building = building;
        this.aprt = aprt;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getAprt() {
        return aprt;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", aprt=" + aprt +
                '}';
    }
}
