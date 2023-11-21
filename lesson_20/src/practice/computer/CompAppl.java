package practice.computer;

import practice.computer.model.Computer;
import practice.computer.model.Laptop;

public class CompAppl {
    public static void main(String[] args) {

        Computer[] shop = new Computer[3];
        System.out.println(shop);
        shop[0] = new Computer("i5", 12, 512, "HP");
        shop[0].setRam(24);
        shop[1] = new Laptop("i7", 16, 512, "Asus", 3, 2.1);
        shop[2] = new Laptop("i7", 24, 1024, "Asus", 3, 2.1);

        for (int i = 0; i < shop.length; i++) {
            System.out.println(shop[i]);

        }


        Object computer = new Computer("i5", 12, 512, "HP");
        Object laptop = new Laptop("i7", 16, 512, "Asus", 3, 2.1);
        System.out.println(computer);
        System.out.println(laptop);
    }
}

