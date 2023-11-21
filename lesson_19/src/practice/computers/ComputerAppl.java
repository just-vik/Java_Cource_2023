package practice.computers;

import practice.computers.model.Computer;
import practice.computers.model.Laptop;

public class ComputerAppl {
    public static void main(String[] args) {
        //создаем массив
        Computer[] comp = new Computer[3];

        comp[0] = new Computer("i9", 32, 512, "HP");

        comp[1] = new Laptop("i5", 8, 256, "Acer", "14'", 1000, 1.8);

        comp[2] = new Laptop("M2", 16, 512, "MacBook", "14", 5000, 1.6);


        for (int i = 0; i < comp.length; i++) {
            System.out.println(comp[i]);
        }

        int sumHdd = 0;
        for (int i = 0; i < comp.length; i++) {
            sumHdd += comp[i].getHdd();
        }
        System.out.println("Total HDD = " + sumHdd);
    }
}
