package supermarket.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarket.dao.Supermarket;
import supermarket.dao.SupermarketImpl;
import supermarket.model.Food;
import supermarket.model.MeatFood;
import supermarket.model.MilkFood;
import supermarket.model.Product;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplTest {

    Supermarket supermarket;
    Product[] prod;

    @BeforeEach
    void setUp() {
        supermarket = new SupermarketImpl();
        prod = new Product[3];

        prod[0] = new Food(1111, "Sausages", 5, "11.11.2023", false);
        prod[1] = new MilkFood(2222, "Milk", 9, "07.11.2023", true,"Cow",3.5);
        prod[2] = new MeatFood(3333, "Kebab", 15, "15.11.2023",true,"Lamb");


        //добавим элементы массива в company
        for (int i = 0; i < prod.length; i++) {
            supermarket.addProduct(prod[i]);

        }
    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(prod[1]));
        Product prod1 = new Food(4444, "Lamb meat", 17, "15.11.2023",true);
        assertTrue(supermarket.addProduct(prod1));
        assertEquals(4, supermarket.quantity());

    }

    @Test
    void findProduct() {
        Product foundProduct = supermarket.findProduct(1111);
        assertNotNull(foundProduct);
        assertEquals("Sausages", foundProduct.getName());

        Product notFoundProduct = supermarket.findProduct(1234);
        assertNull(notFoundProduct);
    }

    @Test
    void updateProduct() {
        boolean updated = supermarket.updateProduct(1111, 10.0);
        assertTrue(updated);

        Product update=supermarket.findProduct(1111);
        assertEquals(10,update.getPrice(),0.01);
    }

    @Test
    void removeProduct() {
        Product removedProduct = supermarket.removeProduct(2222);
        assertNotNull(removedProduct);
        assertEquals(2, supermarket.quantity());

        Product notFoundProduct = supermarket.removeProduct(1234);
        assertNull(notFoundProduct);
        assertEquals(2, supermarket.quantity());
    }


    @Test
    void quantity() {
        assertEquals(3, supermarket.quantity());
    }

    @Test
    void totalPrice() {
        assertEquals(29, supermarket.totalPrice(), 0.01);
    }

    @Test
    void testFindProductPassExtDate(){
        Product[] productsWithMatchingDate = supermarket.findProductPassExtDate("07.11.2023");
        assertEquals(1, productsWithMatchingDate.length);
        assertEquals(2222, productsWithMatchingDate[0].getBarcode());
    }
}