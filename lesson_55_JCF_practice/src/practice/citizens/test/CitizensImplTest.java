package practice.citizens.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.citizens.dao.CitizenHashSetImpl;
import practice.citizens.dao.Citizens;
import practice.citizens.dao.CitizensImpl;
import practice.citizens.dao.CitizensSetImpl;
import practice.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTest {

    Citizens citizens;
    static final LocalDate now = LocalDate.now();


    @BeforeEach
    void setUp() {
        citizens = new CitizenHashSetImpl(List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(23)),
                new Person(4, "Bruce", "Willis", now.minusYears(25))
        ));
    }

    @Test
    void addTest() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(2, "John", "Smith", now.minusYears(20))));
        assertEquals(4, citizens.size());
        assertTrue(citizens.add(new Person(5, "Jack", "Willis", now.minusYears(25))));
        assertEquals(5, citizens.size());
    }

    @Test
    void removeTest() {
        assertFalse(citizens.remove(5)); //удаляем отсутствующего
        assertEquals(4, citizens.size()); // убеждаемся в количестве персон
        assertTrue(citizens.remove(4));
        assertEquals(3, citizens.size());
    }

    @Test
    void findTest() {
        Person person = citizens.find(1);
        assertEquals(1, person.getId());
        assertEquals("Peter", person.getFirstName());
        assertEquals("Jackson", person.getLastName());
        assertEquals(23, person.getAge());
        assertNull(citizens.find(5));
    }

    @Test
    void testFindByLastName() {
        //могут быть однофамильцы
        Iterable<Person> personIterable = citizens.find("Jackson");
        //перенесем полученных в результате поиска в ArrayList
        List<Person> actual = new ArrayList<>();
        for (Person person : personIterable) {
            actual.add(person);
        }
        Collections.sort(actual);// сортировка по id
        List<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(3, "Mary", "Jackson", now.minusYears(20))
        );
        assertIterableEquals(expected, actual, "Проверка поиска однофамильцев");
    }

    @Test
    void testFindByAgeRange() {
        Iterable<Person> personIterable = citizens.find(20, 23);
        //перенесем полученных в результате поиска в ArrayList
        List<Person> actual = new ArrayList<>();
        for (Person person : personIterable) {
            actual.add(person);
        }
        Collections.sort(actual);// сортировка по id
        List<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(23))
        );
        assertIterableEquals(expected, actual, "Проверка поиска однофамильцев");
    }

    @Test
    void getAllPersonsSortedById() {
        //проверить что метод отберет все персоны и отсортированы по id,
        // то есть, id текущего < id следующего.
        Iterable<Person> personIterable = citizens.getAllPersonsSortedById();
        int id = -1; //первый id которого еще нет
        int count = 0;
        for (Person person : personIterable) {
            count++;
            assertTrue(person.getId() > id); //следующий id больше предыдущего
            id = person.getId();//переназначаем id
        }
        assertEquals(count, citizens.size());
    }

    @Test
    void getAllPersonsSortedByAge() {
        Iterable<Person> personIterable = citizens.getAllPersonsSortedByAge();
        int age = -1;
        int count = 0;
        for (Person person : personIterable) {
            count++;
            assertTrue(person.getAge() >= age);
            age = person.getAge();
        }
        assertEquals(count, citizens.size());
    }

    @Test
    void getAllPersonsSortedByLastName() {
        Iterable<Person> personIterable = citizens.getAllPersonsSortedByLastName();
        String lastName = "";
        int count = 0;
        for (Person person : personIterable) {
            count++;
            assertTrue(person.getLastName().compareTo(lastName) >= 0);
            lastName = person.getLastName();
        }
        assertEquals(count, citizens.size());
    }

    @Test
    void size() {
        assertEquals(4,citizens.size());
    }
}