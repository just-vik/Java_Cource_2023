package practice;

// Имеются оценки абитуриента из его аттестата, всего 20 оценок.
// Найдите средний балл абитуриента.
public class Abiturient {
    public static void main(String[] args) {
        //объявили и заполнили
        int[] mark = {2, 3, 3, 1, 4, 5, 3, 1, 1, 4};
        int subOfMarks = 0;

        for (int i = 0; i < mark.length; i++) {
            // subOfMarks = subOfMarks + mark[i]; // длинно, но понятно
            subOfMarks += mark[i]; //короткая запись
        }

        double averageMark = (double) subOfMarks / mark.length; //делим на количество оценок
        System.out.println("Average mark: " + averageMark);
        System.out.printf("Average mark: %.2f", averageMark);

    }
}
