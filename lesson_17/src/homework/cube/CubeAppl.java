package homework.cube;

import homework.cube.model.Cube;

public class CubeAppl {
    public static void main(String[] args) {
        Cube c1 = new Cube(2);
        Cube c2 = new Cube(4);
        System.out.println("      CUBE №1");
        System.out.println("Perimeter : " + c1.cubePerimeter() + " сm");
        System.out.println("Volume : " + c1.cubeVolume() + " сm³");
        System.out.println("Square : " + c1.cubeSquare() + " сm²");
        System.out.println("---------------------------------------------------");
        System.out.println("      CUBE №2");
        System.out.println("Perimeter : " + c2.cubePerimeter() + " сm");
        System.out.println("Volume : " + c2.cubeVolume() + " сm³");
        System.out.println("Square : " + c2.cubeSquare() + " сm²");

    }
}
