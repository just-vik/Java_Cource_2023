package supermarket.dao;

import supermarket.model.Food;
import supermarket.model.Product;

import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {
    //    поля
    private Product[] products;
    private int quantity;

    public SupermarketImpl() {
        this.products = new Product[100]; // Инициализируйте с подходящим размером.
        this.quantity = 0;
    }


    @Override
    public boolean addProduct(Product product) {
        if (product == null || quantity == products.length || findProduct(product.getBarcode()) != null) {
            return false;
        }
        products[quantity] = product;
        quantity++;
        return true;
    }

    @Override
    public Product removeProduct(int barcode) {
        for (int i = 0; i < quantity; i++) {
            if (products[i].getBarcode() == barcode) {
                Product victim = products[i]; //убрали найденный элемент в переменную
                products[i] = products[quantity - 1]; //на место найденного поставили последний существующего в массиве
                products[quantity - 1] = null; //обнулили последнего
                quantity--;
                // можно написать этот код короче TODO
                return victim;
            }
        }
        return null;
    }

    @Override
    public Product findProduct(int barcode) {
        for (int i = 0; i < quantity; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                return products[i];
            }
        }
        return null;
    }


    @Override
    public boolean updateProduct(int barcode, double newPrice) {
        for (int i = 0; i < quantity; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                products[i].setPrice(newPrice);
                return true;
            }
        }
        return false;
    }


    @Override
    public void printAllProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }

    @Override
    public int quantity() {
        return quantity;
    }

    @Override
    public double totalPrice() {
        double total = 0.0;
        for (int i = 0; i < quantity; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    @Override
    public Product[] findProductPassExtDate(String extDate) {
        return findProductByPredicate(product -> product instanceof Food && extDate.equals(((Food) product).getExpDate()));
    }


    //Predicate метод в методе (об этом говорит private)
    private Product[] findProductByPredicate(Predicate<Product> predicate) {
        int count = 0;
        for (int i = 0; i < quantity; i++) {
            if (predicate.test(products[i])) {
                count++;
            }
        }
        //создаем массив под посчитанное количество
        Product[] res = new Product[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(products[i])) {
                res[j++] = products[i];
            }
        }
        return res;
    }
}
