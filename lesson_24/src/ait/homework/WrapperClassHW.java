package ait.homework;

public class WrapperClassHW {
    public static void main(String[] args) {
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);


        Integer myInt1 = 5;
        Double myDouble1 = 5.99;
        Character myChar1 = 'A';
        System.out.println(myInt1.intValue());
        System.out.println(myDouble1.doubleValue());
        System.out.println(myChar1.charValue());


        Integer myInt2 = 23456;
        String myString = myInt2.toString();
        System.out.println(myString.length());

        Integer integer1 = Integer.valueOf("6");
        Integer integer2 = Integer.valueOf(6);
        System.out.println(integer1);
        System.out.println(integer2);


        Long long1 = Long.valueOf("45");
        long long2 = Long.parseLong("45");
        long1=long1+long1;
        System.out.println("long1 = " + long1);
        long2=long2+long2;
        System.out.println("long2 = " + long2);
    }
}
