package homework.citizens.dao;

import homework.citizens.model.Person;

public interface Citizens {
    boolean add(Person person);

    boolean remote(int id);

    Person find(int id);

    Iterable<Person> find(int minAge, int maxAge); //список граждан в возрасте от и до

    Iterable<Person> find(String lastName);

    Iterable<Person> getAllSortedById();

    Iterable<Person> getAllSortedByAge();

    Iterable<Person> getAllSortedByLastName();

    int size();

}
