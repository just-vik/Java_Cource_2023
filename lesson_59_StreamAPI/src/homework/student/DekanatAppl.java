package homework.student;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DekanatAppl {
    public static void main(String[] args) {
        Student[] students = new Student[14];

        students[0] = new Student(101, "Alice", "Johnson", "2000-03-15", 2, 11, "US", "female");
        students[1] = new Student(102, "William", "Johnson", "1998-08-05", 3, 12, "EN", "male");
        students[2] = new Student(103, "Mario", "Rossi", "2001-09-10", 1, 10, "IT", "male");
        students[3] = new Student(104, "Mei", "Chen", "2001-10-18", 3, 12, "CH", "female");
        students[4] = new Student(105, "Bob", "Smith", "1999-05-20", 3, 12, "US", "male");
        students[5] = new Student(106, "Emma", "Williams", "2000-04-30", 1, 10, "EN", "female");
        students[6] = new Student(107, "Lukas", "Müller", "2001-09-18", 3, 12, "Germany", "male");
        students[7] = new Student(108, "Giulia", "Bianchi", "2002-11-25", 2, 11, "IT", "female");
        students[8] = new Student(109, "Li", "Wang", "1999-06-12", 2, 11, "CH", "male");
        students[9] = new Student(110, "Haruto", "Sato", "1997-07-22", 2, 11, "Japan", "male");
        students[10] = new Student(111, "Erik", "Larsson", "1999-05-03", 1, 13, "Sweden", "male");
        students[11] = new Student(112, "Yui", "Tanaka", "1998-08-12", 3, 12, "Japan", "female");
        students[12] = new Student(113, "Emma", "Andersson", "2000-04-25", 2, 11, "Sweden", "female");
        students[13] = new Student(114, "Sophie", "Schneider", "2002-11-30", 1, 13, "Germany", "female");

        List<Student> studentList = new ArrayList<>();
        studentList.addAll(Arrays.asList(students)); //создаем список List из массива students и добавляем всех студентов в studentList.
//        for (int i = 0; i < students.length; i++) {
//            studentList.add(students[i]);
//        }

        //сортировка студентов по курсу
        studentsSortedByCourse(studentList);
        //сортировка студентов по номеру группы
        studentsSortedByGroupNum(studentList);
        //сортировка студентов по LastName
        studentsSortedByLastName(studentList);
        //сортировка студентов по Age
        studentsSortedByAge(studentList);
        //diversity
        genderStatistics(studentList);
        // Вычисление среднего возраста по курсам
        averageAgeByCourse(studentList);
        // Вычисление общего среднего возраста
        totalAverageAge(studentList);

    }

    private static void studentsSortedByCourse(List<Student> students) {
        System.out.println("-----------studentsSortedByCourse---------");
        List<Student> sortedByCourse = students.stream()
                .sorted(Comparator.comparingInt(Student::getCourse))
                .collect(Collectors.toList());
        sortedByCourse.forEach(System.out::println);
    }

    private static void studentsSortedByGroupNum(List<Student> students) {
        System.out.println("-----------studentsSortedByGroupNum---------");
        List<Student> sortedByGroupNum = students.stream()
                .sorted(Comparator.comparingInt(Student::getGroupNum))
                .collect(Collectors.toList());
        sortedByGroupNum.forEach(System.out::println);
    }

    private static void studentsSortedByLastName(List<Student> students) {
        System.out.println("-----------studentsSortedByLastName---------");
        List<Student> sortedByLastName = students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
        sortedByLastName.forEach(System.out::println);

    }

    private static void studentsSortedByAge(List<Student> students) {
        System.out.println("-----------studentsSortedByAge---------");
        List<Student> sortedByAge = students.stream()
                .sorted(Comparator.comparing(Student::getBirtDay))
                .collect(Collectors.toList());
        sortedByAge.forEach(System.out::println);

    }

    private static void genderStatistics(List<Student> students) {
        long maleCount = students.stream().filter(student -> student.getGender().equalsIgnoreCase("male")).count();
        long femaleCount = students.size() - maleCount;
        long totalCount = students.size();
        double malePercentage = ((double) maleCount / totalCount) * 100;
        double femalePercentage = 100 - malePercentage;
        System.out.println("Кoл-во мужчин: " + maleCount + " => " + malePercentage + " %");
        System.out.println("Кoл-во женщин: " + femaleCount + " => " + femalePercentage + " %");
    }

    private static void averageAgeByCourse(List<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.mapping(Student::getBirtDay, Collectors.toList())))
                .forEach((course, birthdays) -> {
                    double avgAge = birthdays.stream().mapToDouble(DekanatAppl::calculateAge).average().orElse(0);
                    System.out.println("Average age on " + course + " course: " + avgAge);
                });
    }

    private static void totalAverageAge(List<Student> students) {
        double totalAvgAge = students.stream()
                .mapToDouble(student -> calculateAge(student.getBirtDay()))
                .average()
                .orElse(0); //возвращает 0, если не удалось вычислить средний возраст
        System.out.println("Total average age: " + totalAvgAge);
    }

    private static double calculateAge(String birthDate) {
        String[] birthDateArray = birthDate.split("-");
        int year = Integer.parseInt(birthDateArray[0]);
        int month = Integer.parseInt(birthDateArray[1]);
        int day = Integer.parseInt(birthDateArray[2]);

        LocalDate now = LocalDate.now();
        int age = now.getYear() - year;
        if (now.getMonthValue() < month || (now.getMonthValue() == month && now.getDayOfMonth() < day)) {
            age--;
        }
        return age;
    }
}
