package shop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.dao.Shop;
import shop.dao.ShopImpl;
import shop.model.Computer;
import shop.model.Laptop;
import shop.model.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {
    Shop shop;
    Computer[] comp;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(5);
        comp = new Computer[4];

        comp[0] = new Computer("1111", 16, 512, "HP",true);
        comp[1] = new Computer("2222", 32, 1000, "Dell",false);
        comp[2] = new Laptop("3333", 16, 512, "McBook",false, "13", 4000, 2);
        comp[3] = new SmartPhone("4444", 12, 256, "One+",true ,"6", 3000, 189, "sony", "black");
        for (int i = 0; i < comp.length; i++) {
            shop.addComputer(comp[i]);
        }
    }

    @Test
    void addComputer() {
        Computer computer = new Computer("6666", 32, 512, "Lenovo", false);

        boolean added = shop.addComputer(computer);
        assertTrue(added);
        assertEquals(5, shop.quantity());

        // Попытка добавить тот же компьютер еще раз
        boolean addedAgain = shop.addComputer(computer);
        assertFalse(addedAgain);
    }

    @Test
    void removeComputer() {
        Computer removed = shop.removeComputer("1111");
        assertNotNull(removed);
        assertEquals(3, shop.quantity());

        Computer notFound = shop.removeComputer("7777");
        assertNull(notFound);
    }

    @Test
    void findComputer() {
        Computer find = shop.findComputer("4444");
        assertNotNull(find);
        assertEquals("One+", find.getBrand());

        Computer notFind = shop.findComputer("7777");
        assertNull(notFind);
    }

    @Test
    void quantity() {
        assertEquals(4, shop.quantity());
        Computer computer = new Computer("6666", 32, 512, "Lenovo", false);
        shop.addComputer(computer);
        assertEquals(5, shop.quantity());
    }

    @Test
    void totalHdd() {
        assertEquals(2280, shop.totalHdd());
    }


    @Test
    void findComputersWithDiscount(){
        shop.printComputers();
        Computer[] discounted = shop.findComputersWithDiscount();
        assertNotNull(discounted);
        assertEquals(2, discounted.length);

    }
}