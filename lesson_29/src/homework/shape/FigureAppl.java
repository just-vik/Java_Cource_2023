package homework.shape;

import homework.shape.model.Circle;
import homework.shape.model.Shape;
import homework.shape.model.Square;
import homework.shape.model.Triangle;

public class FigureAppl {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[4];

        shapes[0] = new Circle(10);
        shapes[1] = new Circle(100);
        shapes[2] = new Triangle(100);
        shapes[3] = new Square(100);

        double total = totalArea(shapes);
        System.out.println("Total area: " + total);
        double total1 = totalPerimeter(shapes);
        System.out.println("Total perimeter: " + total1);
        double total2 = totalAreaCircle(shapes);
        System.out.println("Total circles area: " + total2);

    }

    private static double totalArea(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcArea();
        }
        return sum;
    }

    private static double totalPerimeter(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcPerimeter();
        }
        return sum;
    }

    private static double totalAreaCircle(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle) {
                sum += shapes[i].calcArea();
            }
        }
        return sum;
    }
}
