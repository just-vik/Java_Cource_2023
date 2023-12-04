package practice.user;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserAppl {

    public static void main(String[] args) {

        User[] users = new User[8];

        users[0] = new User(1, "Michael", "Robert", 37, "TR");
        users[1] = new User(2, "Mary", "Patricia", 21, "EN");
        users[2] = new User(3, "John", "Michael", 17, "FR");
        users[3] = new User(4, "Jennifer", "Linda", 77, "TR");
        users[4] = new User(5, "William", "Elizabeth", 23, "US");
        users[5] = new User(6, "Sue", "Jackson", 16, "IT");
        users[6] = new User(7, "Michael", "Tommy", 37, "EN");
        users[7] = new User(8, "Bill", "Mirray", 56, "EN");

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            userList.add(users[i]);
        }

        // Перебор всех элементов userList с помощью forEach() и вывод их в консоль
        printUsers(userList);
        // Перебор всех элементов с выполнением некоторой операции над каждым элементом списка и вывод их в консоль.
        // Вместо имени только инициалы
        printUsersInitials(userList);
        // Сортировка списка по полю age
        printUsersSortedByAge(userList);
        // Сортировка списка по нескольким свойствам: age, firstName, lastName.
        printUsersSortedByAgeAndNames(userList);
        // средний возраст
        calcUsersAvgAge(userList);
        // Проверка, что у всех User возраст (age) больше 18
        isAgeMore18(userList, 18);
        // Количество пользователей из разных стран
        calcUserByCountries(userList);

    }

    private static void calcUserByCountries(List<User> userList) {
        System.out.println("-----------------UserByCountries-------------------");
        long countDifferentCountries = userList.stream()
                .map(User::getCountry)
                .distinct()//извлекаем дубликаты
                .count();
        System.out.println("Count Different countries: " + countDifferentCountries);
    }

    private static void isAgeMore18(List<User> userList, int age) {
        // Проверка, что у всех User возраст (age) больше 18
        int checkAge = age;
        System.out.println("-----------------isAgeMore18-------------------");
        boolean isAgeMore18 = userList.stream()
                .allMatch(user -> user.getAge() >= checkAge);
        System.out.println("Are all users grate than " + checkAge + " : " + isAgeMore18);
        long countUnder18 = userList.stream()
                .filter(user -> user.getAge() < 18)
                .count();
        System.out.println("Number of users with age less than 18: " + countUnder18 + " persons");
    }

    private static void calcUsersAvgAge(List<User> userList) {
        //Вычисление среднего возраста (age)
        System.out.println("------------------calcUsersAvgAge------------------");
        double averageAge = userList.stream()
                .mapToInt(User::getAge)
                .summaryStatistics()
                .getAverage();
        System.out.print("averageAge: " + averageAge);
        System.out.println();
    }

    private static void printUsersSortedByAgeAndNames(List<User> userList) {
        //Сортировка списка по нескольким свойствам: age, lastName.
        System.out.println("------------------SortedByAgeAndNames------------------");
        userList.stream()
                .map(u -> {
                    return new User(
                            u.getId(),
                            u.getFirstName().charAt(0) + ".",
                            u.getLastName().charAt(0) + ".",
                            u.getAge(),
                            u.getCountry());
                })
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getLastName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void printUsersSortedByAge(List<User> userList) {
        // Сортировка списка по полю age
        System.out.println("-----------------SortedByAge-------------------");
        userList.stream()
                .map(u -> {
                    return new User(
                            u.getId(),
                            u.getFirstName().charAt(0) + ".",
                            u.getLastName().charAt(0) + ".",
                            u.getAge(),
                            u.getCountry());
                })
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    private static void printUsersInitials(List<User> userList) {
        // Перебор всех элементов с выполнением некоторой операции над каждым элементом списка и вывод их в консоль.
        // Вместо имени только инициалы
        System.out.println("-----------------UsersInitials-------------------");
        userList.stream()
                .map(u -> {
                    return new User(
                            u.getId(),
                            u.getFirstName().charAt(0) + ".",
                            u.getLastName().charAt(0) + ".",
                            u.getAge(),
                            u.getCountry());
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void printUsers(List<User> userList) {
        // Перебор всех элементов userList с помощью forEach() и вывод их в консоль
        System.out.println("------------------------------------");
        userList.stream()
                .forEach(System.out::println);
        System.out.println("------------------------------------");
    }

}
