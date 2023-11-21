package homework.shape.model;

public class Triangle extends Shape {

    public Triangle(double side) {
        this.side = side;
    }

    @Override
    public double calcArea() {
        return side * side * (Math.sqrt(3) / 4);
    }

    @Override
    public double calcPerimeter() {
        return side * 3;
    }
}
