package practice.student;

public class Studend {
    //поля
    private int id;
    private String firstName;
    private String secondName;

    private int[] marks;

    //конструктор полный
    public Studend(int id, String firstName, String secondName, int[] marks) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.marks = marks;
    }

    //конструктор пустой
    public Studend() {
    }


    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    //equals и hashCode только по id для идентификации студента
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Studend studend = (Studend) o;

        return id == studend.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    // метод, который считает средний бал студента
    public double averageMark(int[] marks) {
        //сложить все оценки
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i]; //накапливаем сумму оценок
        }
        // разделить на их количество
        return sum/(double)marks.length;

    }
}
