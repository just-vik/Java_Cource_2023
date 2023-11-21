package practice.mystring;

import java.util.Iterator;

public class MyStringApp {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("To be or not to be");
        MyString myString = new MyString(str);

        Iterator<Character> iterator = myString.iterator();

        while (iterator.hasNext()){
            char ch = iterator.next(); //получим следующий элемент
            if (ch=='e') {
                iterator.remove(); //пробежали итератором по строке и удалили все буквы е
            }
        }
        System.out.println(myString);


//        System.out.println("================ add character =================");
//        myString.addChar('!');
//        System.out.println(myString);
//
//        System.out.println("================ remove character =================");
//        myString.removeChar('r');
//        System.out.println(myString);
//
//        // печать всей строки большими буквами с помощью toUpperCase
//        System.out.println("================ printing in capital letters =================");
//        StringBuilder builder =myString.getStr(); // в переменную builder забрали содержимое
//        for (int i = 0; i < builder.length(); i++) {
//            char c = builder.charAt(i);
//            c = Character.toUpperCase(c);
//            System.out.print(c);
//        }
////        StringBuilder builder = myString.getStr(); // Получаем содержимое строки
////        String c = builder.toString().toUpperCase(); // Преобразуем строку в верхний регистр
////        System.out.println(c); // Выводим строку в верхнем регистре
//
//        // другой программист делает:
//        System.out.println();
//        builder.setLength(5); //обрезали длинну строки
//        System.out.println(builder); //напечатали
//        System.out.println(myString); // изменилась

    }

}
