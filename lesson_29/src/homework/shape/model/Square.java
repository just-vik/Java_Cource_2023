package homework.shape.model;

public class Square extends Shape {
    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    @Override
    public double calcPerimeter() {
        return side * 4;
    }
}
