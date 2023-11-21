package consultation.predicate;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        // x -> x > 0  лямбда выражение
        System.out.println("================== is Positive ======================");
        Predicate<Integer> isPositive = x -> x > 0; //объявили предикат и сразу вписали условие, которое будет проверяться
        System.out.println(isPositive.test(56));  // true
        System.out.println(isPositive.test(-56)); // false

        System.out.println("=================== is Odd =====================");
        Predicate<Integer> isOdd = n -> n % 2 == 1; //проверка на нечетное число
        System.out.println(isOdd.test(5)); //true
        System.out.println(isOdd.test(8)); //false

        System.out.println("=================== is Starts With 'W' =====================");
        Predicate<String> isStartsWithW = s -> s.charAt(0)=='W';
        System.out.println(isStartsWithW.test("Wolf")); //true
        System.out.println(isStartsWithW.test("Fox"));  //false

        System.out.println("=================== contains Java =====================");
        Predicate<String> containsJava =s->s.contains("Java");
        System.out.println(containsJava.test("Welcome to Java")); //true
        System.out.println(containsJava.test("Welcome to Ja"));   //false

    }
}
