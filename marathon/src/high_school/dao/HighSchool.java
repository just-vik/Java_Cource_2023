package high_school.dao;

import high_school.model.Person;

public interface HighSchool {
    boolean addPerson(Person person);

    Person removePerson(int id);

    Person findPerson(int id);

    int personCount();

    void printPerson();
}

