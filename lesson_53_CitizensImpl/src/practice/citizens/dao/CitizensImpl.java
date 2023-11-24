package practice.citizens.dao;

import practice.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    // fields
    private List<Person> idList; // список граждан по id

    private List<Person> lastNameList; // список граждан по фамилиям

    private List<Person> ageList; // список граждан по годам

    //        private static Comparator<Person> lastNameComparator = (p1, p2) -> {
//        int res = p1.getLastName().compareTo(p2.getLastName());
//        return res != 0 ? res :Integer.compare(p1.getId(),p2.getId());
//    };
    private static Comparator<Person> lastNameComparator = Comparator.comparing(Person::getLastName).thenComparingInt(Person::getId);

    private static Comparator<Person> ageComparator = Comparator.comparing(Person::getAge).thenComparingInt(Person::getId);

    // constructor
    // пустой конструктор
    public CitizensImpl() {
        idList = new ArrayList<>();//создаем пустой лист
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this(); //вызов пустого конструктора
        for (Person person : citizens) {
            add(person);
        }
    }

    //O(n)
    @Override
    public boolean add(Person person) {
        // будем вносить объекты Person сразу в 3 листа
        // поддерживая их сортировку.
        if (person == null) {
            return false;
        }
//O(log(n))
        int index = Collections.binarySearch(idList, person); //ищем индекс в idList, быстрый поиск
        if (index >= 0) {
            return false;
        }
        index = -index - 1;
        //O(n) - потому что этот метод от ArrayList
        idList.add(index, person);
//O(log(n))
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index >= 0 ? index : -index - 1;
        //O(n) - потому что этот метод от ArrayList
        ageList.add(index, person);
//O(log(n))
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index >= 0 ? index : -index - 1;
        //O(n) - потому что этот метод от ArrayList
        lastNameList.add(index, person);

        return true;
    }

    //O(log(n))
    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if (victim == null) {
            return false;
        }
        idList.remove(victim);
        return true;
    }

    //O(log(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, null, null, null);
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index); //нашли и вернули объект по его индексу
    }

    //O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person pattern = new Person(Integer.MIN_VALUE, null, null, now.minusYears(minAge));
        int from = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;

        pattern = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
        int to = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
        return ageList.subList(from, to);

    }

    //O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person pattern = new Person(Integer.MIN_VALUE, null, lastName, null);
        int from = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;

        pattern = new Person(Integer.MAX_VALUE, null, lastName, null);
        int to = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
        return lastNameList.subList(from, to);
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;//возвращаем ссылку на память где лежит idList
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;//возвращаем ссылку
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;//возвращаем ссылку
    }

    //O(1)
    @Override
    public int size() {
        return idList.size();//возвращаем ссылку
    }
}
