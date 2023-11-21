package ait.product;

import ait.product.dao.Supermarket;
import ait.product.model.Food;
import ait.product.model.Product;

public class SupermarketApp {
    public static void main(String[] args) {
        Supermarket kiosk = new Supermarket(5);
        kiosk.addProduct(new Product(1000, "Gift card", 20));
        kiosk.addProduct(new Food(2000, "Sausages", 5, "20.10.2023", false));
        kiosk.addProduct(new Food(3000, "Goat cheese", 13, "31.12.2023", true));
        kiosk.addProduct(new Food(4000, "Pork fat", 3, "15.11.2023", true));
        System.out.println(kiosk.getQuantity());
        kiosk.printAllProducts();

        System.out.println("====================Add==========================");
        kiosk.addProduct(new Product(5000, "Book", 5));
        kiosk.printAllProducts();

        System.out.println("====================Find==========================");
        Product product = kiosk.findProduct(2000);
        System.out.println(product);
        System.out.println("==================Update=====================");
        kiosk.updateProduct(2000, 11.77);
        System.out.println(product);

        System.out.println("==================Remote=====================");
        kiosk.removeProduct(2000);
        System.out.println(kiosk.getQuantity());
        kiosk.printAllProducts();

//        Supermarket kiosk = new Supermarket(4);
//        kiosk.addProduct(new Product(1000, "Gift card", 20));
//        kiosk.addProduct(new Food(2000, "Sausages", 5, "20.10.2023", false));
//        kiosk.addProduct(new Food(3000, "Goat cheese", 13, "31.12.2023", true));
//        kiosk.addProduct(new Food(4000, "Pork fat", 3, "15.11.2023", true));
//        System.out.println(kiosk.getQuantity());
//
//        kiosk.addProduct(null);
//
//        kiosk.printAllProducts();
//        System.out.println("==================All Product====================");
//
//        Product product = kiosk.findProduct(2000);
//        System.out.println(product);
//        System.out.println("=================Find======================");
//
//        //test updateProduct
//        kiosk.updateProduct(2000,20.50);
//        System.out.println(product);
//
//        System.out.println("==================Remote=====================");
//        kiosk.removeProduct(2000);
//        System.out.println(kiosk.getQuantity());
//        kiosk.printAllProducts();


    }
}
