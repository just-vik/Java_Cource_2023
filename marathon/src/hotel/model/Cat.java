package hotel.model;

public class Cat extends Pets {
    private String breed;
    private double weight;
    private double height;

    public Cat(int id, String type, int age, String nickname, double dailyRate, String breed, double weight, double height) {
        super(id, type, age, nickname, dailyRate);
        this.breed = breed;
        this.weight = weight;
        this.height = height;
    }


}
