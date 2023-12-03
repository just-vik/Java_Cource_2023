package practice.citizens.dao;

import practice.citizens.model.Person;

import java.util.*;

public class CitizenHashSetImpl implements Citizens {

    private HashSet<Person> citizens;
    //comparators for sorting
    private static Comparator<Person> lastNameComparator = Comparator.comparing(Person::getLastName).thenComparingInt(Person::getId);
    private static Comparator<Person> ageComparator = Comparator.comparing(Person::getAge).thenComparingInt(Person::getId);
    private static Comparator<Person> idComparator = Comparator.comparing(Person::getId).thenComparingInt(Person::getId);
    //need a comparator by id?

    //empty constructor (create empty HashSet)
    public CitizenHashSetImpl() {
        citizens = new HashSet<>();
    }

    //constructor with an initial list of citizens
    public CitizenHashSetImpl(List<Person> citizens) {
        this();//call empty constructor(citizens)
        this.citizens.addAll(citizens);
    }

    //addition
    @Override
    public boolean add(Person person) {
        if (person == null){
            return false;
        }
        return citizens.add(person);
    }

    //remove
    @Override
    public boolean remove(int id) {
        Person person = find(id);
        return person != null && citizens.remove(person);
    }

    //search by ID
    @Override
    public Person find(int id) {
        for (Person person : citizens) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    //search by age range
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        List<Person> result = new ArrayList<>();
        for (Person person : citizens) {
            if (person.getAge() >= minAge && person.getAge() <= maxAge) {
                result.add(person);
            }
        }
        return result;
    }

    //search by LastName
    @Override
    public Iterable<Person> find(String lastName) {
        List<Person> result = new ArrayList<>();
        for (Person person : citizens) {
            if (person.getLastName().equals(lastName)) {
                result.add(person);
            }
        }
        return result;
    }

    //sorting by Id
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        //create new list (from the HashSet to the ArrayList)
        List<Person> sortedById = new ArrayList<>(citizens);
        //sort list by age (comparator 'lines 10-12')
        sortedById.sort(idComparator);
        //return sorted list
        return sortedById;
    }

    //sorting by Age
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        List<Person> sortedByAge = new ArrayList<>(citizens);
        sortedByAge.sort(ageComparator);
        return sortedByAge;
    }

    //sorting by LastName
    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        List<Person> sortedByLastName = new ArrayList<>(citizens);
        sortedByLastName.sort(lastNameComparator);
        return sortedByLastName;
    }

    @Override
    public int size() {
        return citizens.size();
    }
}
