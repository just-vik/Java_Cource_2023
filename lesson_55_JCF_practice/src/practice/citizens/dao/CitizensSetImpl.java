package practice.citizens.dao;

import practice.citizens.model.Person;

import java.time.LocalDate;
import java.util.*;

public class CitizensSetImpl implements Citizens {
    // fields
    private TreeSet<Person> idList; // список граждан по id

    private TreeSet<Person> lastNameList; // список граждан по фамилиям

    private TreeSet<Person> ageList; // список граждан по годам
    private static Comparator<Person> lastNameComparator = Comparator.comparing(Person::getLastName).thenComparingInt(Person::getId);
    private static Comparator<Person> ageComparator = Comparator.comparing(Person::getAge).thenComparingInt(Person::getId);

    public CitizensSetImpl() {
        idList = new TreeSet<>();//создаем пустое множество
        lastNameList = new TreeSet<>(lastNameComparator);//за сет компаратора поддерживается уникальность множества
        ageList = new TreeSet<>(ageComparator);
    }

    public CitizensSetImpl(List<Person> citizens) {
        this(); //вызов пустого конструктора
        for (Person person : citizens) {
            //citizens.forEach(p -> add(p));
            citizens.forEach(this::add); //новый синтаксис с лямбда выражением
        }
    }

    //O(long(n))
    @Override
    public boolean add(Person person) {
        return person != null && idList.add(person) && lastNameList.add(person) && ageList.add(person);
    }

    //O(long(n))
    @Override
    public boolean remove(int id) {
        Person person = find(id);
        return person != null && idList.remove(person) && lastNameList.remove(person) && ageList.remove(person);
    }

    //O(long(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, null, null, null);
        Person person = idList.ceiling(pattern);//Метод ищет в бинарном дереве снизу вверх (ceiling)
        return pattern.equals(pattern) ? person : null;
    }

    //O(long(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person from = new Person(idList.first().getId() - 1, null, null, now.minusYears(minAge));
        Person to = new Person(idList.last().getId() + 1, null, null, now.minusYears(maxAge));
        return ageList.subSet(from, to); //берем подмножество (subSet)
    }

    //O(long(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person from = new Person(Integer.MIN_VALUE, null, lastName, null);
        Person to = new Person(Integer.MAX_VALUE, null, lastName, null);
        return lastNameList.subSet(from, to); //берем подмножество (subSet)
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    //O(1)
    @Override
    public int size() {
        return idList.size();
    }
}
