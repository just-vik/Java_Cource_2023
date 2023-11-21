package hotel.test;

import hotel.dao.Hotel;
import hotel.dao.HotelImpl;
import hotel.model.Cat;
import hotel.model.Dog;
import hotel.model.Pets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class HotelImplTest {
    Hotel hotel;
    Pets[] pet;

    @BeforeEach
    void setUp() {
        hotel = new HotelImpl(5);
        pet = new Pets[4];

        pet[0]=new Pets(10,"pig",2,"Josy",10);
        pet[1]=new Cat(20,"cat",1,"Margo",6,"british",1.4,23);
        pet[2]=new Cat(30,"cat",3,"Max",6,"manx",2.1,25);
        pet[3]=new Dog(40,"dog",1,"Rex",8,"poodle",12.5,37);
        for (int i = 0; i < pet.length; i++) {
            hotel.addPet(pet[i]);
        }
    }

    @Test
    void addPet() {
        Pets p = new Dog(50, "dog2", 2, "Sandra", 8,"bulldog",13.6,31);
        boolean added = hotel.addPet(p);
        assertTrue(added);
        assertEquals(5, hotel.qty());

        boolean addedAgain = hotel.addPet(p);
        assertFalse(addedAgain);
    }

    @Test
    void findPetById() {
        Pets find = hotel.findPetById(20);
        assertNotNull(find);
        assertEquals("Margo", find.getNickname());

        Pets notFind = hotel.findPetById(60);
        assertNull(notFind);
    }

    @Test
    void removePet() {
        Pets removed = hotel.removePet(20);
        assertNotNull(removed);
        assertEquals(3, hotel.qty());
        Pets notFound = hotel.removePet(60);
        assertNull(notFound);
    }

    @Test
    void findPetsByType() {
        Pets[] foundCats = hotel.findPetsByType("cat");
        assertNotNull(foundCats);
        assertEquals(2, foundCats.length);

        for (Pets pet : foundCats) {
            assertEquals("cat", pet.getType());
        }

        Pets[] notFoundHorses = hotel.findPetsByType("horse");
        assertNull(notFoundHorses);
    }

    @Test
    void calcStayCost() {
        double cost = hotel.calcStayCost(20,5); // Предполагаем корректную реализацию
        assertEquals(30, cost); // Указание ожидаемого значения
        double cost1 = hotel.calcStayCost(10,3);
        assertEquals(30, cost1);
    }

    @Test
    void calcTotalRevenue() {
        double revenue = hotel.calcTotalRevenue();
        assertEquals(30, revenue);
    }

}