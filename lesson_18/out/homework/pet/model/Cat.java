package homework.pet.model;

public class Cat extends Pet {
    private String breed; // порода
    private double height; // рост
    private double weight; // вес

    //constructor

    public Cat(int id, String typePet, int age, String nickName, String breed, double height, double weight) {
        super(id, typePet, age, nickName);
        this.breed = breed;
        this.height = height;
        this.weight = weight;
    }


    //getter and setter

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void voice() {
        System.out.println("The "+ getNickName() + " say МЯУ!....");
    }

    public void displayCat() {
        System.out.println("Breed: " + breed + "| Height: " + height + "| Weight: " + weight);
    }
}
