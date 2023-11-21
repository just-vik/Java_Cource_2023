package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class CompAppl {
    public static void main(String[] args) {
        Computer[] shop = new Computer[5];
        shop[0] = new Computer("i5", 12, 512, "HP");
        shop[1] = new Laptop("i7", 24, 1024, "Asus", 3, 2.1);
        shop[2] = new Laptop("i7", 24, 1024, "Asus", 3, 2.1);
        shop[3] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 123456789);
        printArray(shop);
        System.out.println("========================================");
        Computer computer = new Computer("i7", 12, 512, "HP");
        boolean checker = shop[0].equals(computer); //сравнение объектов через equals
        System.out.println(checker);
        System.out.println("========================================");
        checker=shop[1].equals(shop[2]);
        System.out.println(checker);
        System.out.println("========================================");
        Smartphone smartphone=new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 123456733);
        checker=smartphone.equals(shop[3]);
        System.out.println(checker);


    }

    public static void printArray(Computer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }
}
