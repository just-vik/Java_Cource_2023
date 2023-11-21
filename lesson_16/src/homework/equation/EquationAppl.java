package homework.equation;

import homework.equation.model.QuadraticEquation;

public class EquationAppl {
    public static void main(String[] args) {
        QuadraticEquation equat1 = new QuadraticEquation(1, 2, 1);
        QuadraticEquation equat2 = new QuadraticEquation(2, 10, 2);

        equat1.display();
        System.out.println("Discriminant: "+equat1.delta());
        System.out.println("Qty roots: "+equat1.quantityRoots());
        System.out.println("-----------------------------------------------");
        equat2.display();
        System.out.println("Discriminant: "+equat2.delta());
        System.out.println("Qty roots: "+equat2.quantityRoots());

    }
}
