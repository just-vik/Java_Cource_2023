package supermarket.dao;

import supermarket.model.Food;
import supermarket.model.Product;

public interface Supermarket {
    //    объявляем методы, только сигнатуры, без тела метода
    boolean addProduct(Product product);

    Product removeProduct(int barcode);

    Product findProduct(int barcode);

    boolean updateProduct(int barcode, double newPrice);

    int quantity();

    double totalPrice();


    void printAllProducts();

    Product[] findProductPassExtDate(String extDate);
}
