package practice.stream_intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAppl {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 9, 2, 8, 3, 7, 4, 6, 5));

        System.out.println("==============================");
        numbers.forEach(System.out::println); // еще один вариант печати
        System.out.println("==============================");

        numbers.stream() //открыл стрим
                .filter(n -> n > 3) //отбираем числа больше 3
                .peek(n -> System.out.println("peek before sort: " + n))//для отлаживания
                .sorted(Comparator.comparingInt(n -> -n)) //sorting через Comparator
                .forEach(System.out::println); //print


        System.out.println("==============================");
        Integer[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        Stream<Integer> streamInt = Arrays.stream(arr)
                .filter(n -> n > 2 && n % 2 == 0)//нужны больше 2 и четные
                .sorted(Comparator.comparingInt(n -> n));
        streamInt.forEach(System.out::println);

        System.out.println("---------------");
        Integer res = Arrays.stream(arr)
                .map(n -> n * 10)//каждое число преобразуется
                .reduce(0, (accum, n) ->  accum + n); //накопление
        System.out.println("sum = " + res);

        System.out.println("==============String================");
        String str = Arrays.stream(arr)
                .sorted(Comparator.comparingInt(n->-n)) //сортировка Integer
                .map(Object::toString)//преобразование Integer to String
                .reduce("Result = ", (accum, n) ->  accum + n);
        System.out.println(str);

    }
}
