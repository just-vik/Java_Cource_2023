package ait.product.dao;

import ait.product.model.Product;

public class Supermarket {
    //    поля класса
    private Product[] products; //массив типа Product
    private int quantity; //текущее кол-во продуктов в массиве(на складе)

    //    конструктор
    public Supermarket(int capacity) {
        products = new Product[capacity]; // создаем новый обьект
    }

    public boolean addProduct(Product product) {
        if (product == null || quantity == products.length || findProduct(product.getBarcode()) != null) {
            return false;
        }
        products[quantity] = product; //добавляем в конец массива
        quantity++; //увеличиваем на 1
        return true;
    }

    public Product findProduct(long barcode) {
        for (int i = 0; i < products.length; i++) { //пробегаем по всем элементам массива
            if (products[i] != null && products[i].getBarcode() == barcode) {
                return products[i];
            }
        }
        return null;
    }

    public Product updateProduct(long barcode, double price) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                products[i].setPrice(price);
                return products[i];
            }
        }
        return null;
    }


    //найти продукт в массиве по его баркоду и удалить элемент массива
    //пусть удаляемый продукт стоит на i-м индексе, тогда все элементы массива надо сдвинуть с места i + 1 нв
    //1 позицию влево, последний элемент присвоить null, длинну массива уменьшить на 1.
    public boolean removeProduct(long barcode) {
        for (int i = 0; i < products.length; i++) {//        проверяем каждый элемент в массиве
            if (products[i] != null && products[i].getBarcode() == barcode) {//            при совпадении баркода сдвигаем элементы влево
//                for (int j = i; j < quantity - 1; j++) {
//                    products[j] = products[j + 1];
//                }
                products[i]=products[quantity-1];
                products[quantity - 1] = null;//                последний элемент массива делаем null
//                уменьшаем количество элементов
                quantity--;
//                завершение метода
                return true;
            }
        }
//        если не нашли бар код возвращаем false
        return false;
    }


    public void printAllProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
