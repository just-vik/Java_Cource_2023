package homework.pets;

import homework.pets.model.Pets;

public class PetsAppl {
    public static void main(String[] args) {
        Pets cat = new Pets(111, "cat", 5, "Tiger");
        Pets dog = new Pets(123, "dog", 8, "Lucky");
        cat.displayPets();
        cat.eat();
        cat.sleep();
        cat.makeSound();
        cat.walk();
        System.out.println("________________________");
        dog.displayPets();
        dog.makeSound();
        dog.walk();
        dog.eat();
        dog.sleep();
    }
}
