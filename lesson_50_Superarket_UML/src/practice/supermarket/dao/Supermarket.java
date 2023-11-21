package practice.supermarket.dao;

import practice.supermarket.model.Product;

public interface Supermarket extends Iterable<Product>{
    boolean addProduct(Product product);

    Product removeProduct(long barCode); //long - смотреть в спецификацию

    Product findByBarCode(long barCode);

    Iterable<Product> findByCategory(String category);

    Iterable<Product> findByBrand(String brand);

    Iterable<Product> findByProductsWithExpiredDate(); // на вход ничего так ка будет пробегать по всем

    int skuQuantity(); //кол-во складских единиц, 1 продукт = 1 sku

}
