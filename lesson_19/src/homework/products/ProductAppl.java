package homework.products;

import homework.products.model.Food;
import homework.products.model.MeatFood;
import homework.products.model.MilkFood;
import homework.products.model.Product;
import practice.computers.model.Computer;

public class ProductAppl {
    public static void main(String[] args) {

        //создаем массив
        Product[] goods = new Product[4];

        goods[0] = new Product("Bread", 1117, 2.4);
        goods[1] = new Food("Chicken salad", 1218, 3.7, "12/01/24");
        goods[2] = new MeatFood("Entrecote", 1519, 8.5, "30/12/23", "beef");
        goods[3] = new MilkFood("Milk", 1716, 1.5, "10.11.23", "cow", 3.5);

        for (int i = 0; i < goods.length; i++) {
            System.out.println(goods[i]);
        }

        double sumPrice = 0;
        for (int i = 0; i < goods.length; i++) {
            sumPrice += goods[i].getPrice();
        }
        System.out.println("Total price = " + sumPrice);
    }
}

