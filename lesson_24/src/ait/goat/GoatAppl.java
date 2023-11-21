package ait.goat;

import ait.goat.model.Goat;


public class GoatAppl {
    public static void main(String[] args) {
        Goat goatling1 = new Goat("Peter");
       //goatling1.name = "Peter";
        for (int i = 0; i < 10; i++) {
            goatling1.increment();
        }
        System.out.println(goatling1);

        Goat goatling2 = new Goat("Vasya");
        //goatling2.name = "Vasya";
        for (int i = 0; i < 15; i++) {
            goatling2.increment();
        }
        System.out.println(goatling2);

        int[] arr=new int[7];
        System.out.println(arr.length); //length поле массива содержащее длину
//        arr.length=100;

        System.out.println(Goat.COUNT_MAX);
        System.out.println(Math.PI);
    }
}
