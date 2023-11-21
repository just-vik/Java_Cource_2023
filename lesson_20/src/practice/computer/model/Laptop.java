package practice.computer.model;



public class Laptop extends Computer {
    private double hours;
    private double weight;

    public Laptop(String cpu, int ram, int hdd, String brand, double hours, double weight) {
        super(cpu, ram, hdd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    //создаем только геттеры
    public double getHours() {
        return hours;
    }

    public double getWeight() {
        return weight;
    }


//    @Override //аннотация переопределения
//    public void display() {
//        super.display();
//        System.out.print(", Hours: " + hours + ", Weight: " + weight);
//    }

    public String toString() {
        return super.toString() + ", Hours: " + hours + ", Weight: " + weight;
    }
}
