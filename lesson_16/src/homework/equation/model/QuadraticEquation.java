package homework.equation.model;

public class QuadraticEquation {
    // определить поля private double a; private double b; private double c;.
    private double a;
    private double b;
    private double c;
//Создать конструктор public QuadraticEquation(double a, double b, double c)
//для инициализации полей

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
//Создать геттеры и сеттеры

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

// Создать метод public void display()
// для печати в консоль квадратного уравнения
    public void display() {
        System.out.println("Quadratic equation: "
                + a + "x^2 + " + b + "x + " + c + " = 0");
    }
    //вычисления дискриминанта D=b2-4ac
    public double delta() {
        return b * 2 - 4 * a * c;
    }
    //вычисления количества корней
    public int quantityRoots() {
        double discriminant = delta();
        //если дискриминант больше 0, то есть 2 корня
        if (discriminant > 0) {
            return 2; // два корня(2 ответа)
        } else if (discriminant == 0) {
            return 1; // один корень(1 ответ)
        } else {
            return 0; // нет корней
        }
    }
}