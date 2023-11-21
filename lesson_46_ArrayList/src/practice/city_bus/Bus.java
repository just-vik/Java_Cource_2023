package practice.city_bus;

import java.util.Objects;

public class Bus implements Comparable<Bus> {
    //fields
    private String model;     // модель
    private String regNumber; // регистрационный номер (подобие ID)
    private String route;     //маршрут
    private int busCapacity;  //кол-во мест в автобусе


    //constructor
    public Bus(String model, String regNumber, String route, int busCapacity) {
        this.model = model;
        this.regNumber = regNumber;
        this.route = route;
        this.busCapacity = busCapacity;
    }


    //getters & setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }


    //to String
    @Override
    public String toString() {
//        return "Bus { " +
//                "model = '" + model + '\'' +
//                ", regNumber = '" + regNumber + '\'' +
//                ", route = '" + route + '\'' +
//                ", busCapacity = " + busCapacity +
//                '}';

        return String.format("Bus { " +
                "\u001B[1mmodel\u001B[0m = %s " +
                ", \u001B[1mregNumber\u001B[0m = %s " +
                ", \u001B[1mroute\u001B[0m = %s " +
                ", \u001B[1mbusCapacity\u001B[0m = %d " +
                " }", model, regNumber, route, busCapacity);
    }


    //equals & hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(regNumber, bus.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }


    //Comparable ---> метод compareTo - сортировка
    @Override
    public int compareTo(Bus o) { // сортируем по маршруту и по вместимости
        int res = this.route.compareTo(o.route); //используем compareTo, так как equals не возвращает Integer
        return res != 0 ? res : -Integer.compare(this.busCapacity, o.busCapacity); // "-" большие автобусы по вместительности выше в списке
    }
}
