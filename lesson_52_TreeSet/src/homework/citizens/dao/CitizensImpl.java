package homework.citizens.dao;

import homework.citizens.model.Person;

import java.util.List;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;


    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remote(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> getAllSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllSortedByLastName() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
