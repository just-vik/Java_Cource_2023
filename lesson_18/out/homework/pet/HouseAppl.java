package homework.pet;

import homework.pet.model.Cat;
import homework.pet.model.Dog;

public class HouseAppl {
    public static void main(String[] args) {
        Cat cat1 = new Cat(10, "Короткошёрстная", 2, "Сабина", "Британская", 23, 4.3);
        Cat cat2 = new Cat(11, "Экзотическая", 6, "Кетти", "Гималайская", 26, 7.5);
        Cat cat3 = new Cat(12, "Длинношерстная", 5, "Каспер", "Персидская", 28, 6.2);

        Dog dog1 = new Dog(13, "Длинношерстная", 4, "Рэй", "Борзая", 68, 17.4);
        Dog dog2 = new Dog(13, "Короткошёрстная", 6, "Люси", "Бульдог", 37, 22.7);
        cat1.displayPet();
        cat1.displayCat();
        cat2.displayPet();
        cat2.displayCat();
        cat3.displayPet();
        cat3.displayCat();
        cat1.sleep();
        cat1.voice();
        cat2.voice();
        cat3.eat();
        cat1.eat();
        cat2.eat();
        cat3.voice();
        cat3.sleep();
        cat1.walk();
        cat2.walk();

        System.out.println("---------------------------------------------");
        dog1.displayPet();
        dog1.displayDog();
        dog2.displayPet();
        dog2.displayDog();
        dog1.sleep();
        dog2.voice();
        dog2.eat();
        dog1.sleep();
        dog1.voice();
        dog1.eat();
        dog1.play();
        dog2.play();
    }
}
