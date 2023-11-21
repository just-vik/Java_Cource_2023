package homework.cube.model;

public class Cube {
    private double a;

    //----------------------------------------

    public Cube(double a) {
        this.a = a;
    }
    //----------------------------------------

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    //Периметр куба = 12 * a;
    //Объем куба = a × a × a = a³;
    //Площадь куба = 6 × a².
    public double cubePerimeter() {
        return 12 * a;
    }
    public double cubeVolume(){
        return a*a*a;
    }

    public double cubeSquare() {
        return 6 * a * a;
    }


    public void display() {
        System.out.println();
    }

}
