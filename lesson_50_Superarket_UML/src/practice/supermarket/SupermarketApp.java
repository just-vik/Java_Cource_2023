package practice.supermarket;

import practice.supermarket.dao.Supermarket;
import practice.supermarket.dao.SupermarketImpl;
import practice.supermarket.model.Product;

import java.time.LocalDate;

public class SupermarketApp {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now(); //определили текущий день

        Supermarket myMarket = new SupermarketImpl();

        myMarket.addProduct(new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5)));
        myMarket.addProduct(new Product(222222, "ChocoMilk", "Dairy", "MilkLand", 13, now.minusDays(3)));
        myMarket.addProduct(new Product(333333, "Cheese Gauda", "Dairy", "Farmer", 22.5, now.plusDays(50)));
        myMarket.addProduct(new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85)));
        myMarket.addProduct(new Product(555555, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25)));

        display(myMarket);

        System.out.println("Products by Brand");
        //должны получить результат от метода
        Iterable<Product> res = myMarket.findByBrand("Milkland");
        display(res);

        System.out.println("Products by Category");
        res = myMarket.findByCategory("dairy");
        display(res);

        System.out.println("Products with expired date >5 days");
        res = myMarket.findByProductsWithExpiredDate();
        display(res);


    }


    //метод для печати
    private static <E> void display(Iterable<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
        System.out.println();
    }
}
