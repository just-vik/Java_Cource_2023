package hotel.model;

public class Dog extends Pets{

    private String breed;
    private double weight;
    private double height;

    public Dog(int id, String type, int age, String nickname, double dailyRate, String breed, double weight, double height) {
        super(id, type, age, nickname, dailyRate);
        this.breed = breed;
        this.weight = weight;
        this.height = height;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
