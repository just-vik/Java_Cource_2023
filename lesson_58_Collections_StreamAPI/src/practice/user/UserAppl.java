package practice.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class UserAppl {
    public static void main(String[] args) {
//  Ваша задача — создать список пользователей
//  выполнить фильтрацию с помощью лямбда-выражений и вывести результат на экран.
//  Найти всех пользователей старше 18 лет.
//  Найти всех пользователей младше 30 лет с именем, начинающимся на букву "A".

        List<User> userList = Arrays.asList(
                new User("Alice", 25),
                new User("Aob", 15),
                new User("Alex", 22),
                new User("Eve", 19),
                new User("Anna", 16),
                new User("John", 28),
                new User("Ali", 45)
        );
        //печать
        print(userList);

        System.out.println("--------------Найти всех пользователей старше 18 лет(как доп условие не более 25)-----------------");
        List<User> userList18 = findUserByPredicate(userList, user -> user.getAge() > 18 && user.getAge() < 25);
        print(userList18);

        System.out.println("--------------Найти всех пользователей младше 30 лет с именем, начинающимся на букву 'A'-----------------");
        List<User> userList30 = findUserByPredicate(userList, user -> user.getAge() < 30 && user.getName().startsWith("A")); // или charAt(0)=='A'
        print(userList30);

    }

    private static List<User> findUserByPredicate(List<User> userList, Predicate<User> predicate) {
        List<User> resList = new ArrayList<>();// создаем структуру для получения результата
        for (User user : userList) {
            if (predicate.test(user)) { // Вернет false ли true. Если тест пройден(true), то мы добавляем результат пользователя.
                resList.add(user);
            }
        }
        return resList;
    }


    private static void print(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
