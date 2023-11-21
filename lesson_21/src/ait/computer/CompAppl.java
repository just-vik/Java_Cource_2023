package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class CompAppl {
    public static void main(String[] args) {
//        double a = 10;//upper casting - восходящее преобразование
//        int b = (int) a;//down casting

        Computer[] shop = new Computer[5];
        shop[0] = new Computer("i5", 12, 512, "HP");
        shop[1] = new Laptop("i7", 16, 512, "Asus", 3, 2.1);
        shop[2] = new Laptop("i7", 24, 1024, "Asus", 3, 2.1);
        shop[3] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24, 0.15, 123456789);
        printArray(shop);
        int total = getTotalSSDCapacity(shop);
        System.out.println("Total SSD capacity = " + total);
//        Laptop laptop1 = (Laptop) shop[1];
//        laptop1.setHours(4.5);
//        System.out.println(laptop1);
//        System.out.println(shop[1]);

        System.out.println("Total Laptop battery hours = " +
                getTotalHoursLaptop(shop));
        System.out.println("Total SSD Laptop capacity = " +
                getTotalSSDLaptopCapacity(shop));


    }

    public static void printArray(Computer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }
    public static int getTotalSSDCapacity(Computer[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) { //чтобы не печатался null
                res += arr[i].getSsd(); //res = res +arr[i].getSsd()
            }
        }
        return res;
    }

    public static double getTotalHoursLaptop(Computer[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] instanceof Laptop) && !(arr[i] instanceof Smartphone)) {
                res += ((Laptop) arr[i]).getHours();
            }
        }
        return res;
    }

    public static int getTotalSSDLaptopCapacity(Computer[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] instanceof Laptop) && !(arr[i] instanceof Smartphone)) {
                res += arr[i].getSsd();
            }
        }
        return res;
    }
}
